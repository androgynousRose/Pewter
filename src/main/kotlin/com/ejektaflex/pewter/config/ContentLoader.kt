package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.TinkerMaterials
import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.integrations.ExampleMaterial
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.logic.MaterialStats
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import net.minecraftforge.fml.common.Loader
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object ContentLoader {

    fun loadContent() {
        saveInternalData()
        loadData(Pewter.BUILTINDIR)
        loadData(Pewter.CUSTOMDIR)
        if (Pewter.CUSTOMDIR.listFiles().isEmpty()) {
            saveExampleMaterial()
        }
    }

    private fun loadData(dir: File) {
        // Load materials as MaterialStats and then register them all
        val loadedMaterials = getMaterialList(dir).map {
            MaterialRegistrar(it)
        }
        Pewter.materials.addAll(loadedMaterials)
        Pewter.LOGGER.info("Loaded ${loadedMaterials.size} materials.")
    }

    private fun saveExampleMaterial() {
        saveDSLMaterial(Pewter.CUSTOMDIR, ExampleMaterial(), "_example")
    }

    private fun saveDSLMaterial(location: File, materialDSL: MaterialDSL, fileName: String? = null) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        try {
            FileWriter("$location\\${fileName ?: materialDSL.tool.name}.json").use { writer ->
                gson.toJson(materialDSL.tool, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun saveInternalData() {
        val existingFiles = Pewter.BUILTINDIR.listFiles()
        val flatMaterials = TinkerMaterials.flattened
        val materialsToSave = flatMaterials.filter { it.second.tool.name in Pewter.CONFIG.builtinsToLoad }
        val materialsToPurge = flatMaterials - materialsToSave

        if (Pewter.CONFIG.purge) {
            val namesOfMaterialsToPurge = materialsToPurge.map { it.second.tool.name }
            for (file in existingFiles) {
                if (file.nameWithoutExtension in namesOfMaterialsToPurge) {
                    Pewter.LOGGER.info("Purging material ${file.nameWithoutExtension}")
                    file.delete()
                }
            }
        }

        // For all builtin materials, save them
        for ((modName, dsl) in materialsToSave) {
            if (Loader.isModLoaded(modName)) {
                if (dsl.tool.name !in existingFiles.map { it.name } || Pewter.CONFIG.overwrite) {
                    Pewter.LOGGER.info("Saving mod $modName material ${dsl.tool.name}")
                    saveDSLMaterial(Pewter.BUILTINDIR, dsl)
                } else {
                    Pewter.LOGGER.info("Skipping integration of ${dsl.tool.name}; file already exists")
                }
            } else {
                Pewter.LOGGER.info("$modName is not loaded, skipping integration...")
            }
        }
    }

    private fun getMaterialList(dir: File): MutableList<MaterialStats> {

        val statList = mutableListOf<MaterialStats>()
        val gson = Gson()

        var filesToLoad = dir.listFiles().toList()

        if (dir == Pewter.BUILTINDIR) {
            Pewter.LOGGER.info("Loading from built in directory only files that are integrated")
            filesToLoad = filesToLoad.filter { it.nameWithoutExtension in Pewter.CONFIG.builtinsToLoad }
            Pewter.LOGGER.info("Those files were: ${filesToLoad.map { it.nameWithoutExtension }}")
        }

        for (file in filesToLoad) {
            when {
                file.name.endsWith(".json") && !file.name.startsWith("_") -> {
                    Pewter.LOGGER.info("Attempting to parse: ${file.name}")
                    val parsedStat = getStatsFromFile(gson, file)
                    parsedStat?.let { statList.add(it) }
                }
            }
        }
        return statList
    }

    // Given a file, return it's parsed stats
    private fun getStatsFromFile(gson: Gson, file: File): MaterialStats? {
        return try {
            val fileContents = String(Files.readAllBytes(file.toPath()))
            gson.fromJson<Any>(fileContents, MaterialStats::class.java) as MaterialStats
        } catch (e: IOException) {
            Pewter.LOGGER.warn("File named ${file.name} could not be found?")
            null
        } catch (e: JsonSyntaxException) {
            Pewter.LOGGER.warn("File named ${file.name} has a JSON syntax error!")
            e.printStackTrace()
            null
        }
    }


}
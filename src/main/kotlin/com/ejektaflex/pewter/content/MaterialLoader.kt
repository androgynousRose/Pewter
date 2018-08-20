package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.materials.example.ExampleMaterial
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.logic.stats.MaterialStats
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import net.minecraftforge.fml.common.Loader
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object MaterialLoader {

    fun loadContent() {
        //saveInternalData()
        loadAllGameData()
        if (Pewter.CONFIG.CUSTOMDIR?.listFiles()?.isEmpty() == true) {
            saveExampleMaterial()
        }
    }

    private fun loadAllGameData() {
        if (Pewter.CUSTOM_LOAD) {
            loadData(Pewter.CONFIG.BUILTINDIR!!)
            loadData(Pewter.CONFIG.CUSTOMDIR!!)
        } else {
            Pewter.materials.addAll(
                    TinkerMaterials().loaded.filter {
                        it.material.name !in Pewter.CONFIG.MAIN.blacklistedMaterials
                    }.map {
                        MaterialRegistrar(it.material)
                    }
            )
        }
        Pewter.LOGGER.info("Loaded ${Pewter.materials.size} materials.")
    }

    private fun loadData(dir: File) {
        // Load materials as MaterialStats and then configure them all
        val loadedMaterials = getMaterialList(dir).map {
            MaterialRegistrar(it)
        }
        Pewter.materials.addAll(loadedMaterials)
    }

    private fun saveExampleMaterial() {
        saveDSLMaterial(Pewter.CONFIG.CUSTOMDIR!!, ExampleMaterial(), "_example")
    }

    private fun saveDSLMaterial(location: File, materialDSL: MaterialDSL, fileName: String? = null) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        try {
            FileWriter("$location\\${fileName ?: materialDSL.material.name}.json").use { writer ->
                gson.toJson(materialDSL.material, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /*
    private fun saveInternalData() {
        val existingFiles = Pewter.CONFIG.BUILTINDIR.listFiles()
        val flatMaterials = TinkerMaterials.flattened
        val materialsToSave = flatMaterials.filter { it.second.material.name !in Pewter.CONFIG.MAIN.blacklistedMaterials }
        val materialsToPurge = flatMaterials - materialsToSave

        if (Pewter.CONFIG.MAIN.purge) {
            val namesOfMaterialsToPurge = materialsToPurge.map { it.second.material.name }
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
                if (dsl.material.name !in existingFiles.map { it.nameWithoutExtension } || Pewter.CONFIG.MAIN.overwrite) {
                    Pewter.LOGGER.info("Saving mod $modName material ${dsl.material.name}")
                    saveDSLMaterial(Pewter.CONFIG.BUILTINDIR, dsl)
                } else {
                    Pewter.LOGGER.info("Skipping integration of ${dsl.material.name}; file already exists")
                }
            } else {
                Pewter.LOGGER.info("$modName is not loaded, skipping integration...")
            }
        }
    }
    */

    private fun getMaterialList(dir: File): MutableList<MaterialStats> {

        val statList = mutableListOf<MaterialStats>()
        val gson = Gson()

        var filesToLoad = dir.listFiles().toList()
        val isBuiltin = dir == Pewter.CONFIG.BUILTINDIR


        if (isBuiltin) {
            Pewter.LOGGER.info("Loading from built in directory only files that are integrated")
            filesToLoad = filesToLoad.filter { it.nameWithoutExtension !in Pewter.CONFIG.MAIN.blacklistedMaterials }
            Pewter.LOGGER.info("Those files were: ${filesToLoad.map { it.nameWithoutExtension }}")
        }

        for (file in filesToLoad) {
            when {
                file.name.endsWith(".json") && !file.name.startsWith("_") -> {
                    Pewter.LOGGER.info("Attempting to parse: ${file.name}")
                    val parsedStat = getStatsFromFile(gson, file)
                    parsedStat?.let {
                        // Mark custom stats as custom
                        if (!isBuiltin) {
                            it.isInCustomFolder = true
                        }
                        statList.add(it)
                    }
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
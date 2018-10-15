package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.api.core.materials.stats.MaterialData
import com.ejektaflex.pewter.lib.InternalAPI
import com.ejektaflex.pewter.lib.PewterInfo
import com.ejektaflex.pewter.lib.PewterLogger
import com.ejektaflex.pewter.mods.unused.MaterialExample
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import net.minecraftforge.fml.common.Loader
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object Configs {

    var configDir: File = File(PewterInfo.CONFIG_FOLDER)

    lateinit var main: MainConfig

    private fun ensureDirectory(base: File, name: String): File {
        val newDir = File(base, name)
        if (!newDir.exists()) {
            newDir.mkdirs()
        }
        return newDir
    }

    fun save() {
        main.grab()
        main.save()
        createExampleFile(configDir)
    }

    fun load() {
        main.grab()
        main.load()
    }

    val externalMaterials: List<MaterialData> by lazy {
        val jsons = configDir.listFiles().filter { it.isFile }.filter { it.extension == "json" && !it.name.startsWith("_") }

        if (jsons.isEmpty()) {
            PewterLogger.warn("Pewter is set to load external JSON files, but none were found.")
        }

        jsons.mapNotNull {
            try {
                val fileContents = String(Files.readAllBytes(it.toPath()))
                gson.fromJson<Any>(fileContents, MaterialData::class.java) as MaterialData
            } catch (e: IOException) {
                PewterLogger.warn("File named ${it.name} could not be found?")
                null
            } catch (e: JsonSyntaxException) {
                PewterLogger.warn("File named ${it.name} has a JSON syntax fatal!")
                e.printStackTrace()
                null
            }
        }
    }

    fun initialize(root: File) {
        configDir = ensureDirectory(root, PewterInfo.MODID)
        main = MainConfig(configDir.path)
    }

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun createExampleFile(location: File) {
        FileWriter("${location.absolutePath}${File.separator}_example.json").use { writer ->
            gson.toJson(MaterialExample().material, writer)
        }
    }

    fun generateMaterialFile(location: File, dsl: MaterialData) {
        FileWriter("${location.absolutePath}${File.separator}_${dsl.name}.json").use { writer ->
            gson.toJson(dsl, writer)
        }
    }

}
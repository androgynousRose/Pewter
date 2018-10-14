package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData
import com.ejektaflex.pewter.lib.InternalAPI
import com.ejektaflex.pewter.mods.unused.MaterialExample
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object Configs {

    var DIR: File = File(Pewter.CONFIG_FOLDER)

    lateinit var MAIN: MainConfig

    private fun ensureDirectory(base: File, name: String): File {
        val newDir = File(base, name)
        if (!newDir.exists()) {
            newDir.mkdirs()
        }
        return newDir
    }


    fun save() {
        MAIN.save()
        createExampleFile(DIR)
    }

    fun load() {
        MAIN.load()
    }

    val externalMaterials: List<MaterialData> by lazy {
        val jsons = DIR.listFiles().filter { it.isFile }.filter { it.extension == "json" && !it.name.startsWith("_") }

        if (jsons.isEmpty()) {
            InternalAPI.warn("Pewter is set to load external JSON files, but none were found.")
        }

        jsons.mapNotNull {
            try {
                val fileContents = String(Files.readAllBytes(it.toPath()))
                gson.fromJson<Any>(fileContents, MaterialData::class.java) as MaterialData
            } catch (e: IOException) {
                InternalAPI.warn("File named ${it.name} could not be found?")
                null
            } catch (e: JsonSyntaxException) {
                InternalAPI.warn("File named ${it.name} has a JSON syntax fatal!")
                e.printStackTrace()
                null
            }
        }
    }

    fun initialize(root: File) {
        DIR = ensureDirectory(root, Pewter.MODID)
        MAIN = MainConfig(DIR.path)
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
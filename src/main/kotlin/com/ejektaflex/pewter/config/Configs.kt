package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData
import com.ejektaflex.pewter.mods.unused.MaterialExample
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object Configs {

    lateinit var DIR: File

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

    val externalMaterials: List<MaterialData>
        get() {
            val jsons = DIR.listFiles().filter { it.isFile }.filter { it.extension == "json" && !it.name.startsWith("_") }

            if (jsons.isEmpty()) {
                Pewter.LOGGER!!.warn("Pewter is set to load external JSON files, but none were found.")
            }

            return jsons.mapNotNull {
                try {
                    val fileContents = String(Files.readAllBytes(it.toPath()))
                    gson.fromJson<Any>(fileContents, MaterialData::class.java) as MaterialData
                } catch (e: IOException) {
                    Pewter.LOGGER!!.warn("File named ${it.name} could not be found?")
                    null
                } catch (e: JsonSyntaxException) {
                    Pewter.LOGGER!!.warn("File named ${it.name} has a JSON syntax error!")
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
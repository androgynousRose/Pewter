package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.materials.example.ExampleMaterial
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.logic.stats.MaterialData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

object MaterialLoader {

    fun loadContent() {

        Pewter.traits = PewterTraits().traits.toMutableList()
        Pewter.modifiers = PewterModifiers.content.toMutableList()

        Pewter.materials.addAll(
                PewterMaterials.content.filter {
                    it.hasMetDependencies()
                }.map {
                    MaterialRegistrar(it.material)
                }
        )

        Pewter.LOGGER.info("Loaded ${Pewter.materials.size} dependencies.")
    }

}
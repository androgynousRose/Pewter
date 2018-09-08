package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.materials.astralsorcery.StarmetalMaterial
import com.ejektaflex.pewter.materials.betterwithmods.HellfireMaterial
import com.ejektaflex.pewter.materials.betterwithmods.SoulforgedSteelMaterial
import com.ejektaflex.pewter.materials.betweenlands.*
import com.ejektaflex.pewter.materials.botania.*
import com.ejektaflex.pewter.materials.thaumcraft.ThaumiumMaterial
import com.ejektaflex.pewter.materials.thaumcraft.VoidMetalMaterial

object PewterMaterials : IPewterContent<MaterialRegistrar> {

    override fun get(id: String): MaterialRegistrar? {
        return content.find { it.data.name == id }
    }

    override fun loadContent(): List<MaterialRegistrar> {
        content = storedContent
        if (Pewter.shouldLoadExternalContent()) {
            content += loadExternalContent()
        }
        return content
    }

    private fun loadExternalContent(): List<MaterialRegistrar> {
        return Configs.externalMaterials.map { MaterialRegistrar(it) }
    }

    private val storedContent: List<MaterialRegistrar> by lazy {

        val toLoad = mutableListOf(
                // Astral Sorcery
                StarmetalMaterial(),

                // Better With Mods
                HellfireMaterial(),
                SoulforgedSteelMaterial(),

                // Botania
                ManasteelMaterial(),
                ManastringMaterial(),
                TerrasteelMaterial(),
                ElementiumMaterial(),
                LivingwoodMaterial(),
                LivingrockMaterial(),

                // Thaumcraft
                ThaumiumMaterial(),
                VoidMetalMaterial(),
                //AlchemicalBrassMaterial(), :( Goodbye friend!

                // The Betweenlands
                OctineMaterial(),
                SyrmoriteMaterial(),
                DragonflyMaterial(),
                ValoniteMaterial(),
                WeedwoodMaterial()
        )

        return@lazy toLoad.mapNotNull {
            dependencyCheck(it)
        }
    }

    override var content = listOf<MaterialRegistrar>()

    private fun dependencyCheck(matDSL: MaterialDSL): MaterialRegistrar? {
        return if (matDSL.hasMetDependencies()) {
            MaterialRegistrar(matDSL.material)
        } else {
            null
        }
    }

}
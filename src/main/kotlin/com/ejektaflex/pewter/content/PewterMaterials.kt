package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.materials.astralsorcery.StarmetalMaterial
import com.ejektaflex.pewter.materials.betterwithmods.HellfireMaterial
import com.ejektaflex.pewter.materials.betterwithmods.SoulforgedSteelMaterial
import com.ejektaflex.pewter.materials.betweenlands.*
import com.ejektaflex.pewter.materials.botania.*
import com.ejektaflex.pewter.materials.thaumcraft.AlchemicalBrassMaterial
import com.ejektaflex.pewter.materials.thaumcraft.ThaumiumMaterial
import com.ejektaflex.pewter.materials.thaumcraft.VoidMetalMaterial

object PewterMaterials {
    val content: List<MaterialDSL>
        get() {
            return listOf(
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
        }
}
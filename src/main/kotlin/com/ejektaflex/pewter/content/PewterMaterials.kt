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
                    StarmetalMaterial(),

                    HellfireMaterial(),
                    SoulforgedSteelMaterial(),

                    ManasteelMaterial(),
                    ManastringMaterial(),
                    TerrasteelMaterial(),
                    ElementiumMaterial(),
                    LivingwoodMaterial(),
                    LivingrockMaterial(),

                    ThaumiumMaterial(),
                    VoidMetalMaterial(),
                    AlchemicalBrassMaterial(),

                    OctineMaterial(),
                    SyrmoriteMaterial(),
                    DragonflyMaterial(),
                    ValoniteMaterial(),
                    WeedwoodMaterial()
            )
        }
}
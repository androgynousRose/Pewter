package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.materials.astralsorcery.StarmetalMaterial
import com.ejektaflex.pewter.materials.betterwithmods.HellfireMaterial
import com.ejektaflex.pewter.materials.betterwithmods.SoulforgedSteelMaterial
import com.ejektaflex.pewter.materials.betweenlands.*
import com.ejektaflex.pewter.materials.botania.*
import com.ejektaflex.pewter.materials.thaumcraft.BrassMaterial
import com.ejektaflex.pewter.materials.thaumcraft.ThaumiumMaterial
import com.ejektaflex.pewter.materials.thaumcraft.VoidMetalMaterial

class TinkerMaterials : ContentList<MaterialDSL>() {
    override val content = mapOf(
            "astralsorcery" to mutableListOf<MaterialDSL>(
                    StarmetalMaterial()
            ),
            "betterwithmods" to mutableListOf(
                    HellfireMaterial(),
                    SoulforgedSteelMaterial()
            ),
            "botania" to mutableListOf(
                    ManasteelMaterial(),
                    ManastringMaterial(),
                    TerrasteelMaterial(),
                    ElementiumMaterial(),
                    LivingwoodMaterial(),
                    LivingrockMaterial()
            ),
            "thaumcraft" to mutableListOf(
                    ThaumiumMaterial(),
                    VoidMetalMaterial(),
                    BrassMaterial()
            ),
            "thebetweenlands" to mutableListOf(
                    OctineMaterial(),
                    SyrmoriteMaterial(),
                    DragonflyMaterial(),
                    ValoniteMaterial(),
                    WeedwoodMaterial()
            )
    )



}
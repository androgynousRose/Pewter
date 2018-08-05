package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.materials.*

object TinkerMaterials {
    val materials = mapOf(
            "astralsorcery" to listOf(
                    StarmetalMaterial()
            ),
            "betterwithmods" to listOf(
                    HellfireMaterial()
            ),
            "botania" to listOf(
                    ManastringMaterial()
            ),
            "thaumcraft" to listOf(
                    ThaumiumMaterial(),
                    VoidMetalMaterial()
            ),
            "thebetweenlands" to listOf(
                    OctineMaterial(),
                    SyrmoriteMaterial(),
                    DragonflyMaterial(),
                    ValoniteMaterial(),
                    WeedwoodMaterial()
            )
    )

    val inListForm: List<MaterialDSL>
        get() {
            return materials.flatMap { entries -> entries.value }
        }

    val flattened: List<Pair<String, MaterialDSL>>
        get() {
            return materials.map { entry -> entry.value.map { entry.key to it } }.flatten()
        }

    fun materialsMatching(names: List<String>): List<Pair<String, MaterialDSL>> {
        return flattened.filter { it.second.material.name in names }
    }

}
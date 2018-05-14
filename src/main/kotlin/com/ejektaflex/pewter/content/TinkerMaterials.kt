package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.integrations.*

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
            )
    )
}
package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.integrations.HellfireMaterial
import com.ejektaflex.pewter.integrations.StarmetalMaterial
import com.ejektaflex.pewter.integrations.ThaumiumMaterial

object TinkerMaterials {
    val materials = mapOf(
            "astralsorcery" to listOf(
                    StarmetalMaterial()
            ),
            "betterwithmods" to listOf(
                    HellfireMaterial()
            ),
            "thaumcraft" to listOf(
                    ThaumiumMaterial()
            )
    )
}
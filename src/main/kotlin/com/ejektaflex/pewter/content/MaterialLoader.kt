package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.logic.MaterialRegistrar

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
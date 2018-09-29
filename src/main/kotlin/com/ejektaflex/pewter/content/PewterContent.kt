package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.modules.*
import com.ejektaflex.pewter.modules.common.ModuleCommonGems

internal object PewterContent {

    private val modules = mutableListOf<PewterModule>()

    fun registerModule(module: PewterModule) {
        modules.add(module)
    }

    init {
        listOf(
                ModuleAstralSorcery(),
                ModuleBetterWithMods(),
                ModuleBotania(),
                ModuleCommonGems(),
                ModuleEmbersRekindled(),
                ModuleThaumcraft(),
                ModuleTheBetweenlands()
        ).filter {
            it.hasMetDependencies()
        }.forEach(this::registerModule)
    }

    fun load() {

        for (module in modules) {
            loadModule(module)
        }

        PewterTraits.setup()
        PewterModifiers.setup()
        PewterMaterials.setup()

    }

    private fun loadModule(module: PewterModule) {
        for (trait in module.toolTraits) {
            PewterAPI.addToolTrait(trait)
        }

        for (mod in module.toolModifiers) {
            PewterAPI.addToolModifier(mod)
        }

        for (mat in module.materials) {
            PewterAPI.addMaterial(mat)
        }

        if (Pewter.isUsingConArm()) {
            for (trait in module.armorTraits) {
                PewterAPI.addArmorTrait(trait)
            }

            for (mod in module.armorModifiers) {
                PewterAPI.addArmorModifier(mod)
            }
        }
    }

}
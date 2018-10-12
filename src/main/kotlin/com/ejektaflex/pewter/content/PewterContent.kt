package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.modules.*
import com.ejektaflex.pewter.modules.common.ModuleCommonGems
import com.ejektaflex.pewter.modules.multi.ModuleThaumBotania

internal object PewterContent {

    private val modules = mutableListOf<PewterModule>()

    fun registerModule(module: PewterModule) {
        if (module.hasMetDependencies()) {
            PewterAPI.log("Registered module: ${module.id}")
            modules.add(module)
        } else {
            PewterAPI.log("Module '${module.id} has unmet dependencies. Skipping integration.")
        }
    }

    init {
        if (Pewter.CONFIG.MAIN.loadPewter) {
            val contentMap = mapOf(
                    "core" to listOf(
                            ModuleAstralSorcery(),
                            ModuleBetterWithMods(),
                            ModuleBotania(),
                            ModuleCommonGems(),
                            ModuleEmbersRekindled(),
                            ModuleMekanism(),
                            ModuleSoot(),
                            ModuleThaumcraft(),
                            ModuleTheBetweenlands()
                    ),
                    "multi_mod" to listOf(
                            ModuleThaumBotania()
                    )
            )
            for (contentList in contentMap.values) {
                contentList.forEach(::registerModule)
            }
        }
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
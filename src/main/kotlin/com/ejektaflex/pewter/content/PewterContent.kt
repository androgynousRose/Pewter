package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.core.PewterLogger
import com.ejektaflex.pewter.modules.astralsorcery.ModuleAstralSorcery
import com.ejektaflex.pewter.modules.betterwithmods.ModuleBetterWithMods
import com.ejektaflex.pewter.modules.botania.ModuleBotania
import com.ejektaflex.pewter.modules.embers.ModuleEmbersRekindled
import com.ejektaflex.pewter.modules.mekanism.ModuleMekanism
import com.ejektaflex.pewter.modules.soot.ModuleSoot
import com.ejektaflex.pewter.modules.thaumcraft.ModuleThaumcraft
import com.ejektaflex.pewter.modules.common.gems.ModuleCommonGems
import com.ejektaflex.pewter.modules.common.magic.ModuleThaumBotania
import com.ejektaflex.pewter.modules.thebetweenlands.ModuleTheBetweenlands

internal object PewterContent {

    private val modules = mutableListOf<PewterModule>()

    fun registerModule(module: PewterModule) {
        if (module.hasMetDependencies()) {
            PewterLogger.info("Registered module: ${module.id}")
            modules.add(module)
        } else {
            PewterLogger.info("Module '${module.id} has unmet dependencies. Skipping integration.")
        }
    }

    init {
        if (Configs.main.shouldLoadPewterContent()) {
            val contentMap = mapOf(
                    "core" to listOf(
                            ModuleMekanism(),
                            ModuleAstralSorcery(),
                            ModuleBetterWithMods(),
                            ModuleBotania(),
                            ModuleCommonGems(),
                            ModuleEmbersRekindled(),
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

        if (Configs.main.isUsingConArm()) {
            for (trait in module.armorTraits) {
                PewterAPI.addArmorTrait(trait)
            }

            for (mod in module.armorModifiers) {
                PewterAPI.addArmorModifier(mod)
            }
        }
    }

}
package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.betterwithmods.*

class ModuleBetterWithMods : PewterModule() {

    override val id = "betterwithmods"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<ModifierFunc<out IPewterArmorTrait>> = mutableListOf(
            ModifierFunc("envious") { ArmorTraitEnvious(this) },
            ModifierFunc("heatlover") { ArmorTraitHeatLover(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialHellfire("hellfire"),
            MaterialSoulforgedSteel("soulforgedsteel")
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<ModifierFunc<out IPewterToolTrait>> = mutableListOf(
            ModifierFunc("heatlover") { ToolTraitHeatLover(this) }
    )

}


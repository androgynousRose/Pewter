package com.ejektaflex.pewter.mods.betterwithmods

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.betterwithmods.*

class ModuleBetterWithMods : PewterModule() {

    override val id = "betterwithmods"

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("envious") { ArmorTraitEnvious(this) },
            EffectWrapper("heatlover") { ArmorTraitHeatLover(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialHellfire("hellfire"),
            MaterialSoulforgedSteel("soulforgedsteel")
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("heatlover") { ToolTraitHeatLover(this) }
    )

}


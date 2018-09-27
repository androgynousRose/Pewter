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

    override val id = "betterWithMods"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitEnvious(),
            ArmorTraitHeatLover()
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialHellfire(),
            MaterialSoulforgedSteel()
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitHeatLover()
    )

}


package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.embers.MaterialDawnstone
import com.ejektaflex.pewter.mods.embers.ToolTraitDawn
import com.ejektaflex.pewter.mods.embers.ToolTraitSimmering

// Just a base for creating new modules; We never use this or extend it
class ModuleEmbersRekindled : PewterModule() {

    override val id = "embers"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            // None
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialDawnstone()
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitDawn(),
            ToolTraitSimmering()
    )

}


package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.embers.*

// Just a base for creating new modules; We never use this or extend it
class ModuleEmbersRekindled : PewterModule() {

    override val id = "embers"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitAshwoven("ashwoven"),
            ArmorTraitBranded("branded")
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialAshenFabric("ashenfabric"),
            MaterialDawnstone("dawnstone")
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitDawn("dawn"),
            ToolTraitSimmering("simmering")
    )

}


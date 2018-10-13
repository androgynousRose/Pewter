package com.ejektaflex.pewter.mods.embers

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.embers.*

// Just a base for creating new modules; We never use this or extend it
class ModuleEmbersRekindled : PewterModule() {

    override val id = "embers"

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("ashwoven") { ArmorTraitAshwoven(this) },
            EffectWrapper("branded") { ArmorTraitBranded(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialAshenFabric("ashenfabric"),
            MaterialDawnstone("dawnstone")
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("dawn") { ToolTraitDawn(this) },
            EffectWrapper("simmering") { ToolTraitSimmering(this) }
    )

}


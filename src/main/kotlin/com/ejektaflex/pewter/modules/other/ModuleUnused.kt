package com.ejektaflex.pewter.modules.other

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait

// Just a base for creating new modules; We never use this or extend it
class ModuleUnused : PewterModule() {

    override val id = "unused_module"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<ModifierFunc<out IPewterArmorTrait>> = mutableListOf(
            // None
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            // None
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<ModifierFunc<out IPewterToolTrait>> = mutableListOf(
            // None
    )

}


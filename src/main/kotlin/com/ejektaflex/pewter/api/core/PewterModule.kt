package com.ejektaflex.pewter.api.core

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait

abstract class PewterModule {

    abstract val id: String

    open val materials = mutableListOf<MaterialDSL>()

    open val toolTraits = mutableListOf<IPewterToolTrait>()

    open val toolModifiers = mutableListOf<ModifierFunc<out IPewterToolModifier>>()

    open val armorTraits = mutableListOf<IPewterArmorTrait>()

    open val armorModifiers = mutableListOf<ModifierFunc<out IPewterArmorModifier>>()

}
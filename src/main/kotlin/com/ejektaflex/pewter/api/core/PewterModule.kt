package com.ejektaflex.pewter.api.core

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import net.minecraftforge.fml.common.Loader

abstract class PewterModule {

    /**
     * A unique identifier for the module. May be used in the future to
     * query the API for modules; Currently unused.
     */
    abstract val id: String

    /**
     * Here you can define the conditions that determine whether or not the
     * module should load.
     */
    open fun hasMetDependencies(): Boolean {
        return Loader.isModLoaded(id)
    }

    open val materials = mutableListOf<MaterialDSL>()

    open val toolTraits = mutableListOf<IPewterToolTrait>()

    open val toolModifiers = mutableListOf<ModifierFunc<out IPewterToolModifier>>()

    open val armorTraits = mutableListOf<IPewterArmorTrait>()

    open val armorModifiers = mutableListOf<ModifierFunc<out IPewterArmorModifier>>()

}
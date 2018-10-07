package com.ejektaflex.pewter.api.core

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import net.minecraftforge.fml.common.Loader

/**
 * A [PewterModule] is a set of materials, tools and traits.
 * [com.ejektaflex.pewter.api.PewterAPI.registerModule] will register this
 * module so that Pewter can load it later on.
 */
abstract class PewterModule {

    /**
     * A unique identifier for the module. May be used in the future to
     * query the API for modules; Currently unused.
     */
    abstract val id: String

    /**
     * Here you can define the conditions that determine whether or not the
     * module should load. By default, it checks whether there is a mod
     * with the same ID as the module ID to determine whether it should load.
     */
    open fun hasMetDependencies(): Boolean {
        return Loader.isModLoaded(id)
    }

    open val materials = mutableListOf<MaterialDSL>()

    open val toolTraits = mutableListOf<EffectWrapper<out IPewterToolTrait>>()

    open val toolModifiers = mutableListOf<EffectWrapper<out IPewterToolModifier>>()

    open val armorTraits = mutableListOf<EffectWrapper<out IPewterArmorTrait>>()

    open val armorModifiers = mutableListOf<EffectWrapper<out IPewterArmorModifier>>()

}

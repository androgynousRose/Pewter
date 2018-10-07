package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule

/**
 * The Pewter API interface. All methods seen here are used by the API.
 */
interface IPewterAPI {

    /**
     * Adds a material definition to Pewter.
     */
    fun addMaterial(material: MaterialDSL) {}

    /**
     * Adds a tool modifier to Pewter.
     */
    fun addToolModifier(mod: EffectWrapper<out IPewterToolModifier>) {}

    /**
     * Adds an armor modifier to Pewter.
     */
    fun addArmorModifier(mod: EffectWrapper<out IPewterArmorModifier>) {}

    /**
     * Adds a tool trait to Pewter.
     */
    fun addToolTrait(mod: EffectWrapper<out IPewterTrait>) {}

    /**
     * Adds an armor trait to Pewter.
     */
    fun addArmorTrait(mod: EffectWrapper<out IPewterTrait>) {}

    /**
     * Used to log API work done by Pewter.
     */
    fun log(any: Any) {}

    /**
     * Adds a content module (a predefined set of materials, modifiers and
     * traits) to Pewter.
     */
    fun registerModule(module: PewterModule) {}

    /**
     * Adds a book repository location from which it can display modifiers in
     * the book "Materials & You"
     */
    fun addToolRepository(location: String) {}

    /**
     * Adds a book repository location from which it can display modifiers in
     * the book "Materials & You: Armory Addendum", if it is loaded.
     */
    fun addArmorRepository(location: String) {}

}
package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import net.minecraft.util.ResourceLocation
import slimeknights.tconstruct.library.modifiers.Modifier

/**
 * All calls to the Pewter API should be done before Pewter loads PreInit.
 * This is because Pewter registers which content to load in PreInit.
 * Make sure your mod is required before Pewter. If using Construct's Armory,
 * make sure your mod is required after that.
 */
interface IPewterAPI {

    /**
     * Adds a material definition to Pewter.
     */
    fun addMaterial(material: MaterialDSL) {}

    /**
     * Adds a tool modifier to Pewter.
     */
    fun addToolModifier(mod: ModifierDef<out Modifier>) {}

    /**
     * Adds an armor modifier to Pewter.
     */
    fun addArmorModifier(mod: ModifierDef<out Modifier>) {}

    /**
     * Adds a tool trait to Pewter.
     */
    fun addToolTrait(mod: IPewterTrait) {}

    /**
     * Adds an armor trait to Pewter.
     */
    fun addArmorTrait(mod: IPewterTrait) {}

    /**
     * Used to log API work done by Pewter.
     */
    fun log(any: Any) {}

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
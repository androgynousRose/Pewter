package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import slimeknights.tconstruct.library.modifiers.Modifier

/**
 * All calls to the Pewter API should be done before Pewter loads PreInit.
 * Make sure your mod is required before Pewter. If using Construct's Armory,
 * make sure your mod is required after that.
 */
interface IPewterAPI {

    /**
     * Adds a material definition to Pewter.
     */
    fun addMaterial(material: MaterialDSL) {}

    /**
     * Adds a tool modifier to Pewter. These modifiers will only conditionally load if
     */
    fun addToolModifier(mod: ModifierDef<out Modifier>) {}

    fun addArmorModifier(mod: ModifierDef<out Modifier>) {}

    fun addToolTrait(mod: Modifier) {}

    fun addArmorTrait(mod: Modifier) {}

    /**
     * Used to log API work done by Pewter.
     */
    fun log(any: Any) {}

}
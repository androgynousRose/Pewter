package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import slimeknights.tconstruct.library.modifiers.Modifier

interface IPewterAPI {

    fun addMaterial(material: MaterialDSL) {}

    fun addToolModifier(mod: ModifierDef<out Modifier>) {}

    fun addArmorModifier(mod: ModifierDef<out Modifier>) {}

    fun addToolTrait(mod: Modifier) {}

    fun addArmorTrait(mod: Modifier) {}

}
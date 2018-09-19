package com.ejektaflex.pewter.lib

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.IPewterAPI
import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.content.PewterTraits
import slimeknights.tconstruct.library.modifiers.Modifier

object InternalPewterAPI : IPewterAPI {

    override fun addToolModifier(mod: ModifierDef<out Modifier>) {
        PewterModifiers.internalContent.add(mod)
    }

    override fun addArmorModifier(mod: ModifierDef<out Modifier>) {
        if (Pewter.isUsingConArm()) {
            PewterModifiers.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Modifier '${mod.identifier}'!")
        }
    }

    override fun addToolTrait(mod: Modifier) {
        PewterTraits.internalContent.add(mod)
    }

    override fun addArmorTrait(mod: Modifier) {
        if (Pewter.isUsingConArm()) {
            PewterTraits.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Trait '${mod.identifier}'!")
        }
    }

    override fun addMaterial(material: MaterialDSL) {
        PewterMaterials.internalContent.add(material)
    }

    override fun log(any: Any) {
        Pewter.LOGGER.info(any)
    }

}
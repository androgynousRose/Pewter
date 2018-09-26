package com.ejektaflex.pewter.lib

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.IPewterAPI
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.module.PewterModule
import com.ejektaflex.pewter.content.PewterContent
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.content.PewterTraits
import slimeknights.mantle.client.book.repository.FileRepository

internal object InternalPewterAPI : IPewterAPI {

    override fun addToolModifier(mod: ModifierFunc<out IPewterToolModifier>) {
        PewterModifiers.internalContent.add(mod)
    }

    override fun addArmorModifier(mod: ModifierFunc<out IPewterArmorModifier>) {
        if (Pewter.isUsingConArm()) {
            PewterModifiers.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Modifier '${mod.identifier}'!")
        }
    }

    override fun addToolTrait(mod: IPewterTrait) {
        PewterTraits.internalContent.add(mod)
    }

    override fun addArmorTrait(mod: IPewterTrait) {
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
        if (Pewter.LOGGER == null) {
            println("Pewter [API]: $any")
        } else {
            Pewter.LOGGER!!.info(any)
        }
    }

    override fun addModule(module: PewterModule) {
        PewterContent.registerModule(module)
    }

    override fun addToolRepository(location: String) {
        try {
            val repo = FileRepository(location)
            BookContentRegistry.toolContent.add(repo)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun addArmorRepository(location: String) {
        try {
            val repo = FileRepository(location)
            BookContentRegistry.armorContent.add(repo)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
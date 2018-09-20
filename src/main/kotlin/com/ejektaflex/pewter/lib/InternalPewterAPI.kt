package com.ejektaflex.pewter.lib

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.IPewterAPI
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.content.PewterTraits
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.repository.FileRepository
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
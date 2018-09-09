package com.ejektaflex.pewter.lib

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.IPewterAPI
import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.content.PewterTraits
import net.minecraftforge.fml.common.Loader
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterAPI : IPewterAPI {
    override fun addToolModifier(mod: ModifierDef<out Modifier>) {
        PewterModifiers.internalContent.add(mod)
    }

    override fun addArmorModifier(mod: ModifierDef<out Modifier>) {
        if (isUsingConArm()) {
            PewterModifiers.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Modifier '${mod.identifier}'!")
        }
    }

    override fun addToolTrait(mod: Modifier) {
        PewterTraits.internalContent.add(mod)
    }

    override fun addArmorTrait(mod: Modifier) {
        if (isUsingConArm()) {
            PewterTraits.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Trait '${mod.identifier}'!")
        }
    }

    override fun addMaterial(material: MaterialDSL) {
        PewterMaterials.internalContent.add(material)
    }

    override val blacklistedMaterials: List<String>
        get() = Pewter.CONFIG.MAIN.blacklistedMaterials

    override val blacklistedModifiers: List<String>
        get() = Pewter.CONFIG.MAIN.blacklistedModifiers

    override fun isUsingConArm() = Pewter.CONFIG.MAIN.conarmIntegration && Loader.isModLoaded("conarm")

}
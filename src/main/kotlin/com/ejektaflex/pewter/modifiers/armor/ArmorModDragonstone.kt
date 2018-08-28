package com.ejektaflex.pewter.modifiers.armor

import c4.conarm.lib.armor.ArmorNBT
import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.ext.comesFrom
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterArmorModifier
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect

class ArmorModDragonstone : PewterArmorModifier("dragonstone", 0xED339A), TinkerNBTChanger {

    init {
        addAspects(ModifierAspect.SingleAspect(this), ModifierAspect.DataAspect(this), ModifierAspect.freeModifier)
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {

        val armorMod: ArmorNBT.() -> Unit = {

            durability += 75
            //toughness += 0.25f

            val numBotaniaMats = baseMaterials(rootCompound).count { it.representativeItem.comesFrom("botania") }.toDouble()

            durability = (durability * (1 + (numBotaniaMats / 10))).toInt()
            //toughness *= (1 + (numBotaniaMats / 25)).toFloat()

        }

        modifyArmorStats(rootCompound, armorMod)
        // No super here :s?
    }

    override fun configure() {
        RecipeMatchHolder.addItem(this, "botania:manaresource:9".toItemStack, 1, 1)
    }

}
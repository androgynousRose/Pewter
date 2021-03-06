package com.ejektaflex.pewter.modules.botania.armor

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.ext.comesFrom
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import net.minecraft.nbt.NBTTagCompound

class ArmorModDragonstone(modName: String) : PewterArmorModifier(modName, 0xED339A), TinkerNBTHelper {

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {

        val armorMod: ArmorNBT.() -> Unit = {

            durability += 75
            //toughness += 0.25f

            val numBotaniaMats = baseMaterials(rootCompound).count { it.representativeItem.comesFrom("botania") }.toDouble()

            durability = (durability * (1 + (numBotaniaMats / 8))).toInt()
            //toughness *= (1 + (numBotaniaMats / 25)).toFloat()

        }

        modifyArmorStats(rootCompound, armorMod)
        super.applyEffect(rootCompound, modifierTag)
    }

    override fun configure() {
        safeAdd("botania:manaresource:9".toItemStack)
    }

}
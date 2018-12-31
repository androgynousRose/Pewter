package com.ejektaflex.pewter.modules.forestry

import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingHurtEvent
import slimeknights.tconstruct.library.modifiers.IModifierDisplay

class ArmorModBeekeeper(modName: String) : PewterArmorModifier(modName, 0xFF5ACB, 2, 3), TinkerNBTHelper, IModifierDisplay {

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {

        println("Was hurt by a: ${source.damageType}, ${source.trueSource}, ${source.immediateSource}, ${source.getDamageType()}")

        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

    override fun configure() {
        safeAdd("minecraft:dirt".toItemStack)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        return super.getExtraInfo(tool, modifierTag)
    }

}
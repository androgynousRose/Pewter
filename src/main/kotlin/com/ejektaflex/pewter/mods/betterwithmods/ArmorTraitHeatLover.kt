package com.ejektaflex.pewter.mods.betterwithmods

import c4.conarm.common.armor.utils.ArmorHelper
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.shared.methods.IModHeatLover
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent

class ArmorTraitHeatLover(name: String) : PewterArmorTrait(name, 0xFF2334), IModHeatLover {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        if (source.trueSource is EntityLivingBase) {
            val target = (source.trueSource as EntityLivingBase)
            if (target.isBurning) {
                ArmorHelper.repairArmor(armor, calcHealAmount(target, random), player)
            }
        }
        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }


}
package com.ejektaflex.pewter.traits.armor

import c4.conarm.common.armor.utils.ArmorHelper
import com.ejektaflex.pewter.lib.mixins.AuraExchanger
import com.ejektaflex.pewter.lib.traits.armor.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools

class ArmorVisBarrier : PewterArmorTrait("Vis Barrier", 0xFF2334), AuraExchanger {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {

        if (getVisAt(player) > DRAIN_AMOUNT && random.nextFloat() < DRAIN_CHANCE) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ARMOR, player, 1)
            ArmorHelper.repairArmor(armor, REPAIR_AMOUNT, player)
            drainVisFor(player, DRAIN_AMOUNT)
        }

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

    companion object {
        const val REPAIR_AMOUNT = 1
        const val DRAIN_CHANCE = 0.15
        const val DRAIN_AMOUNT = 1.8f
    }

}
package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.mixins.AuraExchanger
import com.ejektaflex.pewter.lib.traits.tools.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import kotlin.math.log10
import kotlin.math.min
import kotlin.math.pow


class Basher : PewterToolTrait("basher", 0xE18EFF), AuraExchanger {
    override fun onToolHeal(tool: ItemStack?, amount: Int, newAmount: Int, entity: EntityLivingBase): Int {
        val netVis = getVisAt(entity) - getFluxAt(entity)
        val visLog = log10(min(1f, netVis))
        val visMult = min(1f, visLog.pow(0.4f))

        return (super.onToolHeal(tool, amount, newAmount, entity) * visMult).toInt()

    }

    override fun knockBack(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, knockback: Float, newKnockback: Float, isCritical: Boolean): Float {

        val knockAmount = if (isCritical) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_BLOOD, target, 2)
            1f
        } else {
            0f
        }

        return super.knockBack(tool, player, target, damage, knockback, newKnockback, isCritical) + 1f
    }

}


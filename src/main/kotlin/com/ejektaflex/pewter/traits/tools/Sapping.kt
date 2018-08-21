package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.ext.random
import com.ejektaflex.pewter.lib.traits.tools.PewterTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.utils.ToolHelper
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import kotlin.math.min


class Sapping : PewterTrait("Sapping", 0x8A134E) {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {

        val healthToSteal = min(target.health, damage) / 7.0f

        if (random.nextFloat() < healChance) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_BLOOD, target, 1)
            if (player.health == player.maxHealth) {
                ToolHelper.healTool(tool, durabilityAddValues.random, player)
            } else {
                player.health += healthToSteal
            }

        }

        super.onHit(tool, player, target, damage, isCritical)
    }

    companion object {
        val durabilityAddValues = listOf(0, 0, 0, 1, 1, 2)
        const val healChance = 0.65f
    }

}
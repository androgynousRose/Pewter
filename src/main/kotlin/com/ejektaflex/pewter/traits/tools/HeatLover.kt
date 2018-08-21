package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.traits.tools.PewterTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.utils.ToolHelper


class HeatLover : PewterTrait("Heat Lover", 0xFF2334) {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {
        if (target.isBurning) {
            val prob = random.nextFloat()
            var healAmount = when {
                prob >= 0.9f -> 2
                prob >= 0.8f -> 1
                else -> 0
            }

            if (target.isInLava) {
                healAmount++
            }

            ToolHelper.healTool(tool, healAmount, player)
        }

        super.onHit(tool, player, target, damage, isCritical)
    }

}
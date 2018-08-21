package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.traits.tools.PewterToolTrait
import com.ejektaflex.pewter.traits.base.IModHeatLover
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.utils.ToolHelper


class HeatLover : PewterToolTrait("Heat Lover", 0xFF2334), IModHeatLover {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {
        if (target.isBurning) {
            ToolHelper.healTool(tool, calcHealAmount(target, random), player)
        }
        super.onHit(tool, player, target, damage, isCritical)
    }

}
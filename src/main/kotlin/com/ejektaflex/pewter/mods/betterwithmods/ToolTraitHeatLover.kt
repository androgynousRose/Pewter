package com.ejektaflex.pewter.mods.betterwithmods

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import com.ejektaflex.pewter.shared.methods.IModHeatLover
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.utils.ToolHelper


class ToolTraitHeatLover(name: String) : PewterToolTrait(name, 0xFF2334), IModHeatLover {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {
        if (target.isBurning) {
            ToolHelper.healTool(tool, calcHealAmount(target, random), player)
        }
        super.onHit(tool, player, target, damage, isCritical)
    }

}
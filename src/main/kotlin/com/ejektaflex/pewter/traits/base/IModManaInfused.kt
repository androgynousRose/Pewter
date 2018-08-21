package com.ejektaflex.pewter.traits.base

import com.ejektaflex.pewter.ext.isAtMaxDurability
import com.ejektaflex.pewter.lib.mixins.ManaExchanger
import com.ejektaflex.pewter.lib.traits.common.SharedTrait
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.ToolHelper

interface IModManaInfused : SharedTrait, ManaExchanger {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        if (!world.isRemote && entity is EntityPlayer && !isAtMaxDurability(tool)) {
            if (hasEnoughMana(tool, entity, MANA_COST) && entity.ticksExisted % 5 == 0) {
                drainManaFor(tool, entity, MANA_COST)
                if (ToolHelper.isBroken(tool)) {
                    ToolHelper.unbreakTool(tool)
                }
                ToolHelper.healTool(tool, 1, entity)
            }
        }
    }

    companion object {
        const val MANA_COST = 120
    }

}
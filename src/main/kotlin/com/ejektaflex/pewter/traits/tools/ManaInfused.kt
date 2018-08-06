package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.ext.isAtMaxDurability
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.ToolHelper
import vazkii.botania.api.mana.ManaItemHandler


class ManaInfused : PewterTrait("manainfused", 0x005EE0) {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {

        if (!world.isRemote && entity is EntityPlayer && !isAtMaxDurability(tool)) {
            val manaToDraw = if (ToolHelper.isBroken(tool)) MANA_COST else UNBREAK_COST
            val hasEnoughMana = ManaItemHandler.requestManaExactForTool(tool, entity, manaToDraw, false)

            if (hasEnoughMana && entity.ticksExisted % 5 == 0) {
                ManaItemHandler.requestManaExactForTool(tool, entity, manaToDraw, true)
                if (ToolHelper.isBroken(tool)) {
                    ToolHelper.unbreakTool(tool)
                }
                ToolHelper.healTool(tool, 1, entity)
            }
        }

        super.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

    companion object {
        const val MANA_COST = 120
        const val UNBREAK_COST = 60
    }

}
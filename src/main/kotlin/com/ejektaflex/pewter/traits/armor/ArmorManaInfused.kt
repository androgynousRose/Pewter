package com.ejektaflex.pewter.traits.armor

import com.ejektaflex.pewter.ext.isAtMaxDurability
import com.ejektaflex.pewter.traits.mixins.ManaExchanger
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.ToolHelper
import vazkii.botania.api.mana.ManaItemHandler

class ArmorManaInfused : PewterArmorTrait("Mana Infused", 0x005EE0), ManaExchanger {

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

        super.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

    companion object {
        const val MANA_COST = 120
        const val UNBREAK_COST = 60
    }

}
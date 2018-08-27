package com.ejektaflex.pewter.traits.base

import com.ejektaflex.pewter.ext.isAtMaxDurability
import com.ejektaflex.pewter.lib.mixins.ManaExchanger
import com.ejektaflex.pewter.lib.traits.base.SharedTrait
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
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

    override fun onToolDamage(tool: ItemStack, damage: Int, newDamage: Int, entity: EntityLivingBase?): Int {
        var toDamage = newDamage
        entity?.let {
            if (!entity.world.isRemote && entity is EntityPlayer && isAtMaxDurability(tool)) {
                if (hasEnoughMana(tool, entity, MANA_COST)) {
                    drainManaFor(tool, entity, MANA_COST)
                    toDamage -= 1
                }
            }
        }
        return toDamage
    }

    companion object {
        const val MANA_COST = 120
    }

}
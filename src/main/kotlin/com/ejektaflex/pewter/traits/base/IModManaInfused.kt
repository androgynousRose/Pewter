package com.ejektaflex.pewter.traits.base

import com.ejektaflex.pewter.ext.isAtMaxDurability
import com.ejektaflex.pewter.lib.mixins.ManaExchanger
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.lib.traits.SharedTrait
import com.ejektaflex.pewter.modifiers.base.methods.IModChange
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.ToolHelper

interface IModManaInfused : SharedTrait, ManaExchanger, TinkerNBTHelper, IModChange<Int> {

    val manaCost: Int

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        if (!world.isRemote && entity is EntityPlayer && !isAtMaxDurability(tool)) {
            val cost = modCost(tool)
            if (hasEnoughMana(tool, entity, cost) && entity.ticksExisted % 5 == 0) {
                drainManaFor(tool, entity, cost)
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
                val cost = modCost(tool)
                if (hasEnoughMana(tool, entity, cost)) {
                    drainManaFor(tool, entity, cost)
                    toDamage -= 1
                }
            }
        }
        return toDamage
    }

}


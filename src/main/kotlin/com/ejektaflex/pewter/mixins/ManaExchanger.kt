package com.ejektaflex.pewter.mixins

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import vazkii.botania.api.mana.ManaItemHandler

interface ManaExchanger {

    fun drainManaFor(item: ItemStack, player: EntityPlayer, amount: Int): Boolean {
        val hasEnoughMana = ManaItemHandler.requestManaExactForTool(item, player, amount, false)
        if (hasEnoughMana) {
            ManaItemHandler.requestManaExactForTool(item, player, amount, true)
        }
        return hasEnoughMana
    }

    fun hasEnoughMana(item: ItemStack, player: EntityPlayer, amount: Int): Boolean {
        return ManaItemHandler.requestManaExactForTool(item, player, amount, false)
    }

}
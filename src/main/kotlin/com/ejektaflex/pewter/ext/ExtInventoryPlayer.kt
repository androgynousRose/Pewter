package com.ejektaflex.pewter.ext

import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.item.ItemStack

operator fun InventoryPlayer.plusAssign(stack: ItemStack) {
    addItemStackToInventory(stack)
}
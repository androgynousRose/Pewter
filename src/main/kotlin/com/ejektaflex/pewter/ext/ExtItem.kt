package com.ejektaflex.pewter.ext

import net.minecraft.item.Item
import net.minecraft.item.ItemStack

operator fun Item.times(n: Int): ItemStack {
    return ItemStack(this, n)
}

val Item.stack: ItemStack
    get() = ItemStack(this, 1)
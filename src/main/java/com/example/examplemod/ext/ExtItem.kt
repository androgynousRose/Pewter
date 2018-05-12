package com.example.examplemod.ext

import net.minecraft.item.Item
import net.minecraft.item.ItemStack

operator fun Item.times(n: Int): ItemStack {
    return ItemStack(this, n)
}
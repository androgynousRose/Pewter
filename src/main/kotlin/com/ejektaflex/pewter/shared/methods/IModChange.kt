package com.ejektaflex.pewter.shared.methods

import net.minecraft.item.ItemStack

interface IModChange<T> {

    val baseChange: T

    fun modCost(item: ItemStack?): T

}
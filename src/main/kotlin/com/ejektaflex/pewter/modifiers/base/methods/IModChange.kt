package com.ejektaflex.pewter.modifiers.base.methods

import net.minecraft.item.ItemStack

interface IModChange<T> {

    val baseChange: T

    fun modCost(item: ItemStack?): T

}
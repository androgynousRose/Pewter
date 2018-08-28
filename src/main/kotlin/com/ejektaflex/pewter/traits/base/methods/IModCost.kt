package com.ejektaflex.pewter.traits.base.methods

import net.minecraft.item.ItemStack

interface IModCost<T> {

    val baseCost: T

    fun modCost(item: ItemStack?): T

}
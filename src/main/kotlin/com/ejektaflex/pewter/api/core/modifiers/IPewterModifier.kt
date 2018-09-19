package com.ejektaflex.pewter.api.core.modifiers

import c4.conarm.lib.utils.RecipeMatchHolder
import net.minecraft.item.ItemStack

interface IPewterModifier {
    // Apparently getItems() crashes if there are no registered items
    fun getItemsSafe(): List<List<ItemStack>>?

    fun safeAdd(stack: ItemStack?)

    fun configure()
}
package com.ejektaflex.pewter.api.core.modifiers

import com.ejektaflex.pewter.api.core.IPewterBaseEffect
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.modifiers.IModifier

interface IPewterModifier : IPewterBaseEffect {
    // Apparently getItems() crashes if there are no registered items
    fun getItemsSafe(): List<List<ItemStack>>?

    fun safeAdd(stack: ItemStack?)

    fun configure()
}
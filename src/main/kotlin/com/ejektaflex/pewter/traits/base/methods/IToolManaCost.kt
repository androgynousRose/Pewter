package com.ejektaflex.pewter.traits.base.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modifiers.tools.ModRuneMana
import net.minecraft.item.ItemStack

interface IToolManaCost : IModCost<Int> {

    override val baseCost
        get() = 200

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ModRuneMana>()
        return (baseCost / (1 + modData.current * 0.165)).toInt()
    }
}
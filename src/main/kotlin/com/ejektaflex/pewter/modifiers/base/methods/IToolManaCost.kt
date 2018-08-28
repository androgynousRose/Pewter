package com.ejektaflex.pewter.modifiers.base.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modifiers.tools.ModRuneMana
import net.minecraft.item.ItemStack

interface IToolManaCost : IModChange<Int> {

    override val baseChange
        get() = 200

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ModRuneMana>()
        return (baseChange / (1 + modData.current * 0.165)).toInt()
    }
}
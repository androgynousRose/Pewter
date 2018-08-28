package com.ejektaflex.pewter.modifiers.base.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modifiers.tools.ModRuneAutumn
import net.minecraft.item.ItemStack

interface IToolHarvestBonus : IModChange<Int> {

    override val baseChange
        get() = 70

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ModRuneAutumn>()
        return (baseChange + (modData.current * 20))
    }
}
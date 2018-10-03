package com.ejektaflex.pewter.shared.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.mods.botania.tool.ToolModRuneAutumn
import net.minecraft.item.ItemStack

interface IToolHarvestBonus : IModChange<Int> {

    override val baseChange
        get() = 70

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ToolModRuneAutumn>()
        return (baseChange + (modData.current * 22))
    }
}
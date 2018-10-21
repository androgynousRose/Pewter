package com.ejektaflex.pewter.shared.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modules.botania.tool.ToolModRuneMana
import net.minecraft.item.ItemStack

interface IToolManaCost : IModChange<Int> {

    override val baseChange
        get() = 200

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ToolModRuneMana>()
        return (baseChange / (1 + modData.current * 0.165)).toInt()
    }
}
package com.ejektaflex.pewter.shared.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modules.botania.armor.ArmorModRuneMana
import net.minecraft.item.ItemStack

interface IArmorManaCost : IModChange<Int> {

    override val baseChange
        get() = 80

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ArmorModRuneMana>()
        return (baseChange / (1 + modData.current * 0.165)).toInt()
    }
}
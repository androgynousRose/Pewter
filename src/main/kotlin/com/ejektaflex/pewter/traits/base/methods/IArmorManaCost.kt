package com.ejektaflex.pewter.traits.base.methods

import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.modifiers.armor.ArmorModRuneMana
import net.minecraft.item.ItemStack

interface IArmorManaCost : IModCost<Int> {

    override val baseCost
        get() = 80

    override fun modCost(item: ItemStack?): Int {
        val modData = item!!.getModifierIntNBT<ArmorModRuneMana>()
        return (baseCost / (1 + modData.current * 0.165)).toInt()
    }
}
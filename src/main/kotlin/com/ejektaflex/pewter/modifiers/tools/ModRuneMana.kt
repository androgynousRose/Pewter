package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import com.ejektaflex.pewter.traits.base.methods.IToolManaCost
import com.ejektaflex.pewter.traits.tools.ManaInfused
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay


class ModRuneMana : PewterModifier("runemana", 0xFF2ACB, 2, 3), TinkerNBTChanger, IModifierDisplay, IToolManaCost {



    override fun configure() {
        addItem("botania:rune:8".toItemStack, 1, 1)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ManaInfused>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseCost - newCost).toFloat() / baseCost * 100)
        return mutableListOf(
                "Tool Mana Use -$percent%"
        )
    }

}

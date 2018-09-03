package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import com.ejektaflex.pewter.modifiers.base.methods.IToolManaCost
import com.ejektaflex.pewter.traits.tools.ManaInfused
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay


class ModRuneMana(modName: String) : PewterModifier(modName, 0xFF5ACB, 2, 3), TinkerNBTChanger, IModifierDisplay, IToolManaCost {

    override fun configure() {
        "botania:rune:8".toItemStack?.let { addItem(it, 1, 1) }
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ManaInfused>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseChange - newCost).toFloat() / baseChange * 100)
        return mutableListOf(
                "Tool Mana Use -$percent%"
        )
    }

}

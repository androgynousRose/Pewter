package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import com.ejektaflex.pewter.modifiers.base.methods.IToolHarvestBonus
import com.ejektaflex.pewter.modifiers.base.methods.IToolManaCost
import com.ejektaflex.pewter.traits.tools.ManaHarvest
import com.ejektaflex.pewter.traits.tools.ManaInfused
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay


class ModRuneAutumn(modName: String) : PewterModifier(modName, 0xE8A136, 2, 3), TinkerNBTChanger, IModifierDisplay, IToolHarvestBonus {

    override fun configure() {
        addItem("botania:rune:6".toItemStack, 1, 1)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ManaHarvest>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseChange - newCost).toFloat() / -baseChange * 100)
        return mutableListOf(
                "Tool Mana Gain +$percent%"
        )
    }

}

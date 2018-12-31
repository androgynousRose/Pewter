package com.ejektaflex.pewter.modules.botania.tool


import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.shared.methods.IToolManaCost
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay


class ToolModRuneMana(modName: String) : PewterToolModifier(modName, 0xFF5ACB, 2, 3), TinkerNBTHelper, IModifierDisplay, IToolManaCost {

    override fun configure() {
        safeAdd("botania:rune:8".toItemStack)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ToolTraitManaInfused>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseChange - newCost).toFloat() / baseChange * 100)
        return mutableListOf(
                "Tool Mana Use -$percent%"
        )
    }

}

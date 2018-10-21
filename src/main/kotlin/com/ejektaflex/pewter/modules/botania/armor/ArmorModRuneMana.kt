package com.ejektaflex.pewter.mods.botania.armor

import com.ejektaflex.pewter.ext.getTinkersModifier
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.shared.methods.IArmorManaCost
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay

class ArmorModRuneMana(modName: String) : PewterArmorModifier(modName, 0xFF5ACB, 2, 3), TinkerNBTHelper, IModifierDisplay, IArmorManaCost {

    override fun applyEffect(rootCompound: NBTTagCompound?, modifierTag: NBTTagCompound?) {}

    override fun configure() {
        safeAdd("botania:rune:8".toItemStack)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ArmorTraitManaInfused>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseChange - newCost).toFloat() / baseChange * 100)
        return mutableListOf(
                "Armor Mana Use -$percent%"
        )
    }

}
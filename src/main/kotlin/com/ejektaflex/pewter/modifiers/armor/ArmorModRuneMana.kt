package com.ejektaflex.pewter.modifiers.armor

import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.ext.getTinkersModifier
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.traits.armor.ArmorManaInfused
import com.ejektaflex.pewter.modifiers.base.methods.IArmorManaCost
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay
import slimeknights.tconstruct.library.modifiers.ModifierAspect

class ArmorModRuneMana : PewterArmorModifier("runemana", 0xFF2AC), TinkerNBTChanger, IModifierDisplay, IArmorManaCost {

    init {
        addAspects(ModifierAspect.DataAspect(this), ModifierAspect.MultiAspect(this, 2, 3, 1))
    }

    override fun applyEffect(rootCompound: NBTTagCompound?, modifierTag: NBTTagCompound?) {}

    override fun configure() {
        "botania:rune:8".toItemStack?.let { RecipeMatchHolder.addItem(this, it, 1, 1) }
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ArmorManaInfused>() in getTraits(stack!!)
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val newCost = modCost(tool!!)
        val percent = "%.0f".format((baseChange - newCost).toFloat() / baseChange * 100)
        return mutableListOf(
                "Armor Mana Use -$percent%"
        )
    }

}
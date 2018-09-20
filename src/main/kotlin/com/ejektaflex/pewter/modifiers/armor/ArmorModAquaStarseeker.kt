package com.ejektaflex.pewter.modifiers.armor

import c4.conarm.lib.armor.ArmorModifications
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.modifiers.base.methods.IModAquaNight
import com.ejektaflex.pewter.modifiers.base.methods.IModChange
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.DamageSource
import slimeknights.tconstruct.library.modifiers.IModifierDisplay

class ArmorModAquaStarseeker(modName: String) : PewterArmorModifier(modName, 0xFF2AC, 2, 15), IModAquaNight, IModChange<Float>, IModifierDisplay {

    override val baseChange = 0f

    override fun modCost(item: ItemStack?): Float {
        return item!!.getModifierIntNBT<ArmorModAquaStarseeker>().current.toFloat() / 10f
    }

    override fun getModifications(player: EntityPlayer?, mods: ArmorModifications?, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        player?.let {
            if (isRightSetting(player)) {
                mods!!.addToughness(modCost(armor)) // Max of 3 toughness
            }
        }
        return super.getModifications(player, mods, armor, source, damage, slot)
    }

    override fun configure() {
        safeAdd("astralsorcery:itemcraftingcomponent".toItemStack) // gemAquamarine
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        return mutableListOf("Night Sky Toughness +${"%.1f".format(modCost(tool))}")
    }

}
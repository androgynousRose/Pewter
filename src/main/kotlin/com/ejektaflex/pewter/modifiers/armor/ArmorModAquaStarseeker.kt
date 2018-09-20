package com.ejektaflex.pewter.modifiers.armor

import c4.conarm.lib.armor.ArmorModifications
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.ext.toItemStack
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource

class ArmorModAquaStarseeker(modName: String) : PewterArmorModifier(modName, 0xFF2AC, 2, 15) {

    // TODO Get this to work
    override fun getModifications(player: EntityPlayer?, mods: ArmorModifications?, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        return super.getModifications(player, mods, armor, source, damage, slot)
    }

    override fun configure() {
        safeAdd("astralsorcery:itemcraftingcomponent".toItemStack) // gemAquamarine
    }

}
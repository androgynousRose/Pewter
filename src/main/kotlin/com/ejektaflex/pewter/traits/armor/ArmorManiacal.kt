package com.ejektaflex.pewter.traits.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import c4.conarm.lib.armor.ArmorModifications
import thaumcraft.api.ThaumcraftApi


class ArmorManiacal : PewterArmorTrait("Maniacal", 0xFF2334) {

    override fun getModifications(player: EntityPlayer, mods: ArmorModifications, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        mods.addToughness(ThaumcraftApi.internalMethods.getActualWarp(player).toFloat() / 25f)
        return mods
    }


}
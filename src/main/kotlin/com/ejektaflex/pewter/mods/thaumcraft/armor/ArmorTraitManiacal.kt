package com.ejektaflex.pewter.mods.thaumcraft.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import c4.conarm.lib.armor.ArmorModifications
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import thaumcraft.api.ThaumcraftApi


class ArmorTraitManiacal : PewterArmorTrait("maniacal", 0xFF2334) {

    override fun getModifications(player: EntityPlayer, mods: ArmorModifications, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        mods.addToughness(ThaumcraftApi.internalMethods.getActualWarp(player).toFloat() / 25f)
        return mods
    }

}
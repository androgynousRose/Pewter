package com.ejektaflex.pewter.traits.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import vazkii.botania.api.mana.ManaItemHandler

class ArmorManaHarvest : PewterArmorTrait("Mana Harvest", 0x401909) {
    override fun onArmorDamage(armor: ItemStack?, source: DamageSource?, damage: Int, newDamage: Int, player: EntityPlayer?, slot: Int): Int {
        ManaItemHandler.dispatchMana(armor, player as EntityPlayer, damage, true)
        return super.onArmorDamage(armor, source, damage, newDamage, player, slot)
    }
}
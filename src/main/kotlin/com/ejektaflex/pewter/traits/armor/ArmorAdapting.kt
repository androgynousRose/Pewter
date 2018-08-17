package com.ejektaflex.pewter.traits.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import c4.conarm.lib.armor.ArmorModifications
import com.ejektaflex.pewter.traits.mixins.ManaExchanger

class ArmorAdapting : PewterArmorTrait("Adapting", 0xE5DFCF), ManaExchanger {
    override fun getModifications(player: EntityPlayer?, mods: ArmorModifications, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        if (player!!.lastDamageSource != null) {
            if (hasEnoughMana(armor!!, player, MANA_COST)) {
                drainManaFor(armor, player, MANA_COST)
                mods.addEffectiveness(0.1f)
            }
        }
        return mods
    }

    companion object {
        const val MANA_COST = 100
    }
}
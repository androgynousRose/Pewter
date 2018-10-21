package com.ejektaflex.pewter.mods.botania.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import c4.conarm.lib.armor.ArmorModifications
import com.ejektaflex.pewter.shared.methods.ManaExchanger
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait

class ArmorTraitAdapting(name: String) : PewterArmorTrait(name, 0xE5DFCF), ManaExchanger {
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
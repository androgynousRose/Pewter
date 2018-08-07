package com.ejektaflex.pewter.traits.armor

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import vazkii.botania.api.mana.ManaItemHandler
import c4.conarm.lib.armor.ArmorModifications

class ArmorAdapting : PewterArmorTrait("Adapting", 0xE5DFCF) {
    override fun getModifications(player: EntityPlayer?, mods: ArmorModifications, armor: ItemStack?, source: DamageSource?, damage: Double, slot: Int): ArmorModifications {
        if (player!!.lastDamageSource != null) {
            val hasEnoughMana = ManaItemHandler.requestManaExactForTool(armor, player, MANA_COST, false)
            if (hasEnoughMana) {
                ManaItemHandler.requestManaExactForTool(armor, player, MANA_COST, true)
                mods.addEffectiveness(0.1f)
            }
        }
        return mods
    }

    companion object {
        const val MANA_COST = 100
    }
}
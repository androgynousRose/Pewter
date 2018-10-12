package com.ejektaflex.pewter.mods.common.magic

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingHurtEvent

class ArmorTraitMagical(name: String) : PewterArmorTrait(name, 0xFF2334) {

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {

        if (player != null && source != null) {
            return if (source.isFireDamage) {
                super.onHurt(armor, player, source, damage, newDamage * (1f - FIRE_BONUS), evt)
            } else {
                super.onHurt(armor, player, source, damage, newDamage * (1f + NORMAL_WEAKNESS), evt)
            }
        }

        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

    companion object {
        const val FIRE_BONUS = 0.15f
        const val NORMAL_WEAKNESS = 0.10f
    }

}
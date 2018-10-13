package com.ejektaflex.pewter.mods.embers

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.shared.methods.IBuffTradeoff
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingHurtEvent

class ArmorTraitAshwoven(name: String) : PewterArmorTrait(name, 0xFF2334), IBuffTradeoff {

    override val buffMult = 0.15f
    override val debuffMult = 0.10f

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {

        if (player != null && source != null) {
            return if (source.isFireDamage) {
                super.onHurt(armor, player, source, damage, newDamage * (1f - buffMult), evt)
            } else {
                super.onHurt(armor, player, source, damage, newDamage * (1f + debuffMult), evt)
            }
        }

        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

}
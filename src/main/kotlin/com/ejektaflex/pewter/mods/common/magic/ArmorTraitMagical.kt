package com.ejektaflex.pewter.mods.common.magic

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.shared.methods.IBuffTradeoff
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingHurtEvent

class ArmorTraitMagical(name: String) : PewterArmorTrait(name, 0xFF2334), IBuffTradeoff {

    override val buffMult = 0.20f
    override val debuffMult = 0.08f

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {

        if (player != null && source != null) {
            return if (source.isMagicDamage) {
                println("MAGIC!")
                newDamage * (10f - buffMult)
            } else {
                println("TYPE: ${source.damageType}")
                newDamage * (1f + debuffMult)
            }
        }

        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

}
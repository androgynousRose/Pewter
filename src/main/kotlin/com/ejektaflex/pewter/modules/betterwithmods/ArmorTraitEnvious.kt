package com.ejektaflex.pewter.modules.betterwithmods

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent

class ArmorTraitEnvious(name: String) : PewterArmorTrait(name, 0x9B9B9B) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        var toDeal = newDamage
        if (source.trueSource is EntityLivingBase) {
            val target = (source.trueSource as EntityLivingBase)

            if (target.totalArmorValue > 0) {
                toDeal *= (1f - ARMOR_REDUCTION)
            }

        }
        return super.onDamaged(armor, player, source, damage, toDeal, evt)
    }

    companion object {
        const val ARMOR_REDUCTION = 0.2f
    }

}
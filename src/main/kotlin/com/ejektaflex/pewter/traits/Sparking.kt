package com.ejektaflex.pewter.traits

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack

class Sparking : PewterTrait("Sparking", 0xF3B72A) {
    override fun onHit(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, isCritical: Boolean) {
        if (!target!!.isDead && random.nextFloat() < CHANCE) {
            target.setFire(BURNING_LENGTH)
        }

        super.onHit(tool, player, target, damage, isCritical)
    }

    override fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, newDamage: Float, isCritical: Boolean): Float {
        var theNewDamage = damage
        if (target!!.isBurning) {
            theNewDamage *= (1f + BURNING_BONUS_DAMAGE)
        }
        return theNewDamage
    }

    companion object {
        const val BURNING_BONUS_DAMAGE = 0.334f
        const val BURNING_LENGTH = 4
        const val CHANCE = 0.15f
    }

}
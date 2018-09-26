package com.ejektaflex.pewter.mods.thebetweenlands.tool

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack

class ToolTraitSparking : PewterToolTrait("sparking", 0xF3B72A) {
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
        const val BURNING_LENGTH = 4 // seconds
        const val CHANCE = 0.18f
    }

}
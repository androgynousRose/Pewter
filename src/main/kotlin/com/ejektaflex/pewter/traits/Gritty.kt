package com.ejektaflex.pewter.traits

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thebetweenlands.common.registries.CapabilityRegistry



class Gritty : PewterTrait("Gritty", 0xC867D7) {
    override fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, newDamage: Float, isCritical: Boolean): Float {


        return if (player!!.hasCapability(CapabilityRegistry.CAPABILITY_DECAY, null)) {
            val cap = player.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null)!!
            damage + (cap.decayStats.decayLevel / 2)
        } else {
            damage
        }

    }

    companion object {
        const val chance = 0.25f
        const val amount = 1.0f
    }

}
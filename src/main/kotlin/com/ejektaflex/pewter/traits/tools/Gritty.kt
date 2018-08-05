package com.ejektaflex.pewter.traits.tools

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
}
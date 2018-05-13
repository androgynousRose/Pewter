package com.ejektaflex.pewter.traits

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.aura.AuraHelper

class Aural : PewterTrait("Aural", 0xFFFFFF) {
    override val motto = "It all bounces back, right?"
    override val description = "Tool use has a chance of feeding off of the Aura instead of using durability"

    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {
        val protoDamage = when (random.nextFloat() < chance) {
            true -> {
                AuraHelper.drainVis(entity.world, entity.position, amount, false)
                newDamage - 1
            }
            false -> newDamage
        }
        return super.onToolDamage(tool, damage, protoDamage, entity)
    }

    companion object {
        const val chance = 0.25f
        const val amount = 1.0f
    }

}
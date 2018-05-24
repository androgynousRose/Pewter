package com.ejektaflex.pewter.traits

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.aura.AuraHelper

class Aural : PewterTrait("Aural", 0xC867D7) {
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
        const val amount = 1.8f
    }

}
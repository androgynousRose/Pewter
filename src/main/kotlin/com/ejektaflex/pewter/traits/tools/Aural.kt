package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.mixins.AuraExchanger
import com.ejektaflex.pewter.lib.traits.tools.PewterTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack

class Aural : PewterTrait("Aural", 0xC867D7), AuraExchanger {
    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {
        val protoDamage = when (random.nextFloat() < chance) {
            true -> {
                drainVisFor(entity, amount)
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
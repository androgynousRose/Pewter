package com.ejektaflex.pewter.modules.thaumcraft.tool

import com.ejektaflex.pewter.shared.methods.AuraExchanger
import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack

class ToolTraitAural(name: String) : PewterToolTrait(name, 0xC867D7), AuraExchanger {
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
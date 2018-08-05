package com.ejektaflex.pewter.traits.tools

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.aura.AuraHelper

class Polluted : PewterTrait("Polluted", 0xD70472) {
    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {
        AuraHelper.polluteAura(entity.world, entity.position, 5f, true)
        return super.onToolDamage(tool, damage, newDamage, entity)
    }
}
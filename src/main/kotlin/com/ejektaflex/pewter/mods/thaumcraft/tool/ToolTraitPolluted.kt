package com.ejektaflex.pewter.mods.thaumcraft.tool

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.aura.AuraHelper

class ToolTraitPolluted : PewterToolTrait("polluted", 0xD70472) {
    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {
        AuraHelper.polluteAura(entity.world, entity.position, 5f, true)
        return super.onToolDamage(tool, damage, newDamage, entity)
    }
}
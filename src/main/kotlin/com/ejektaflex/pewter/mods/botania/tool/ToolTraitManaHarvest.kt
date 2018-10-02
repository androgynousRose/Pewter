package com.ejektaflex.pewter.mods.botania.tool

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import com.ejektaflex.pewter.shared.methods.IToolHarvestBonus
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import vazkii.botania.api.mana.ManaItemHandler

class ToolTraitManaHarvest(name: String) : PewterToolTrait(name, 0x005EE0), IToolHarvestBonus {

    override fun damage(tool: ItemStack?, player: EntityLivingBase, target: EntityLivingBase, damage: Float, newDamage: Float, isCritical: Boolean): Float {
        if (damage > target.health) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ELECTRO, target, 2)
            ManaItemHandler.dispatchMana(tool, player as EntityPlayer, modCost(tool), true)
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical)
    }

}
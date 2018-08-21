package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.traits.tools.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import vazkii.botania.api.mana.ManaItemHandler

class ManaHarvest : PewterToolTrait("manaharvest", 0x005EE0) {

    override fun damage(tool: ItemStack?, player: EntityLivingBase, target: EntityLivingBase, damage: Float, newDamage: Float, isCritical: Boolean): Float {

        if (damage > target.health) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ELECTRO, target, 2)
            ManaItemHandler.dispatchMana(tool, player as EntityPlayer, MANA_GAIN, true)
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical)
    }

    companion object {
        const val MANA_GAIN = 70
    }

}
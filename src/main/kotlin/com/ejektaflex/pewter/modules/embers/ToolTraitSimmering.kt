package com.ejektaflex.pewter.modules.embers

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import kotlin.math.min


class ToolTraitSimmering(name: String) : PewterToolTrait(name, 0xE84C22) {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {

        val addedDamage = when(target.posY) {
            in 0.0..10.0 -> maxExtraDamage
            in 10.0..60.0 -> ((60.0 - target.posY) / 50.0 * maxExtraDamage).toFloat()
            else -> 0f
        }

        val numHearts = min(1, addedDamage.toInt() / 2)

        TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_FIRE, target, numHearts)

        super.onHit(tool, player, target, damage + addedDamage, isCritical)
    }

    companion object {
        const val maxExtraDamage = 4f
    }

}
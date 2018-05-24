package com.ejektaflex.pewter.traits

import com.ejektaflex.pewter.ext.get
import com.ejektaflex.pewter.ext.random
import com.ejektaflex.pewter.ext.set
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import kotlin.math.min
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.Tags.DURABILITY


class Sapping : PewterTrait("Sapping", 0x8A134E) {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {

        val healthToSteal = min(target.health, damage) / 7.0f

        if (random.nextFloat() < healChance) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_BLOOD, target, 1)
            if (player.health == player.maxHealth) {
                val tag = TagUtil.getToolTag(tool)
                val tagAttack = tag.get<Float>(DURABILITY)
                tag[DURABILITY] = tagAttack + durabilityAddValues.random
            } else {
                player.health += healthToSteal
            }

        }

        super.onHit(tool, player, target, damage, isCritical)
    }

    companion object {
        val durabilityAddValues = listOf(0, 0, 0, 1, 1, 2)
        const val healChance = 0.65f
    }

}
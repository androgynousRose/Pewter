package com.ejektaflex.pewter.modules.embers

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.TinkerToolCore
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.roundToInt


class ToolTraitDawn(name: String) : PewterToolTrait(name, 0xFFB337), TinkerNBTHelper {
    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase?, damage: Float, isCritical: Boolean) {
        return when (player.world.isRemote) {
            true -> super.onHit(tool, player, target, damage, isCritical)
            false -> {
                target?.setFire((calculateEffect(tool) * 2).roundToInt())
                super.onHit(tool, player, target, damage, isCritical)
            }
        }
    }

    override fun knockBack(tool: ItemStack?, player: EntityLivingBase, target: EntityLivingBase?, damage: Float, knockback: Float, newKnockback: Float, isCritical: Boolean): Float {
        return when (player.world.isRemote) {
            true -> super.knockBack(tool, player, target, damage, knockback, newKnockback, isCritical)
            false -> super.knockBack(tool, player, target, damage, knockback, newKnockback + calculateEffect(tool!!), isCritical)
        }
    }

    private fun calculateEffect(tool: ItemStack): Float {
        val attackSpeed = (tool.item as? TinkerToolCore)?.attackSpeed()?.toFloat()
        attackSpeed?.let {
            val calcAttack = it * statsOf(tool).attackSpeedMultiplier
            val clippedAttack = max(0.5f, 1f / calcAttack)
            return (clippedAttack * (log10(clippedAttack) + 1.2f))
        }
        return 0f
    }

}


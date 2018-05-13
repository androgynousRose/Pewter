package com.ejektaflex.pewter.traits

import com.ejektaflex.pewter.ext.currentBiome
import com.ejektaflex.pewter.ext.temperature
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import kotlin.math.abs
import kotlin.math.ceil


class HeatLover : PewterTrait("Heat Lover", 0xFFFFFF) {
    override val description = "More brittle in cold biomes, more durable in warm biomes"

    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {

        val targetTemp = 1.0f // Hot!

        val tempDistance = abs(entity.temperature - targetTemp)

        val toDamage = when {
            // 70% chance to damage when close to range
            tempDistance < 0.26f -> if (random.nextFloat() > 0.3) {
                1
            } else {
                0
            }
            else -> ceil(tempDistance * 5).toInt() - 1
        }

        return super.onToolDamage(tool, damage, toDamage, entity)
    }

}
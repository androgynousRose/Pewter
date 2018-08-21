package com.ejektaflex.pewter.traits.base

import net.minecraft.entity.EntityLivingBase
import java.util.*

interface IModHeatLover {

    fun calcHealAmount(target: EntityLivingBase, random: Random): Int {
        var amt = 0
        val prob = random.nextFloat()
        amt += when {
            prob >= 0.9f -> 2
            prob >= 0.8f -> 1
            else -> 0
        }

        if (target.isInLava) {
            amt++
        }
        return amt
    }

}
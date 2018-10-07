package com.ejektaflex.pewter.shared.methods

import net.minecraft.entity.EntityLivingBase

interface EntityBonus<N : Number> {

    val bonusInterfaces: Set<String>

    fun calculateEntityBonus(e: EntityLivingBase, original: Float, func: EntityLivingBase.() -> Unit): N

}
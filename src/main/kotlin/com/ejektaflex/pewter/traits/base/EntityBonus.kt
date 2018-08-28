package com.ejektaflex.pewter.traits.base

import net.minecraft.entity.Entity

interface EntityBonus<E, N : Number> {

    fun calculateEntityBonus(e: Entity?, original: Float, func: E.() -> Unit): N

}
package com.ejektaflex.pewter.ext

import com.ejektaflex.pewter.Pewter
import net.minecraft.util.ResourceLocation
import java.util.*

val String.resource: ResourceLocation
    get() = ResourceLocation(Pewter.MODID, this)

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start

fun Random.range(closed: ClosedRange<Int>): Int {
        return nextInt(closed.endInclusive - closed.start) + closed.start
}

val <T> List<T>.random: T
    get() = this[Random().range(0 until size)]
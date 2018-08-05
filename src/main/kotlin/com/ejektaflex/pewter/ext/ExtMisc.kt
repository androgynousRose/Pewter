package com.ejektaflex.pewter.ext

import com.ejektaflex.pewter.Pewter
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import slimeknights.tconstruct.library.modifiers.Modifier
import java.util.*

val String.resource: ResourceLocation
    get() = ResourceLocation(Pewter.MODID, this)

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive + 1 - start) +  start

fun Random.range(closed: ClosedRange<Int>): Int {
        return nextInt(closed.endInclusive + 1 - closed.start) + closed.start
}

val <T> List<T>.random: T
    get() = this[Random().range(0 until size)]

fun Random.chanceOf(f: Float, func: () -> Unit) {
    if (nextFloat() < f) {
        func()
    }
}
package com.ejektaflex.pewter.ext

import com.ejektaflex.pewter.lib.PewterInfo
import net.minecraft.command.ICommandSender
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World
import java.util.*

val String.resource: ResourceLocation
    get() = ResourceLocation(PewterInfo.MODID, this)

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

fun ICommandSender.sendMessage(str: String) {
    sendMessage(TextComponentString(str))
}

fun nonRemote(world: World, func: () -> Unit) {
    if (!world.isRemote) {
        func()
    }
}

fun <T> nonRemote(world: World, default: T, func: () -> T): T {
    return if (!world.isRemote) {
        func()
    } else {
        default
    }
}

package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.modifiers.ModStick
import com.ejektaflex.pewter.modifiers.PewterMod

object TinkerModifiers {
    val modifiers = mapOf<PewterMod, PewterMod.() -> Unit>(
            ModStick() to { it: PewterMod ->
                it.addItem("minecraft:stick".toItemStack!!.item)
            }
    )
}
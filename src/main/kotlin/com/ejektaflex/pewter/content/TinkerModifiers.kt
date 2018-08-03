package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.modifiers.ModStick
import com.ejektaflex.pewter.modifiers.ModStone
import com.ejektaflex.pewter.modifiers.PewterMod

object TinkerModifiers {
    val modifiers = mapOf<PewterMod, PewterMod.() -> Unit>(
            // Not ready for debut yet; They don't show up in the book!
            //*
            ModStick() to { it: PewterMod ->
                it.addItem("minecraft:stick".toItemStack!!.item)
            },

            ModStone() to { it: PewterMod ->
                it.addItem("minecraft:stone".toItemStack!!.item)
            }

            //*/
    )
}

//it.addItem("minecraft:stick".toItemStack!!.item)
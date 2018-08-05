package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.modifiers.ModStick
import com.ejektaflex.pewter.modifiers.ModStone
import slimeknights.tconstruct.library.modifiers.Modifier

class TinkerModifiers {
    companion object {
        val modifiers = mapOf<Modifier, Modifier.() -> Unit>(
                // Not ready for debut yet; They don't show up in the book!
                /*
                ModStick() to { it: Modifier ->
                    it.addItem("minecraft:stick".toItemStack!!.item)
                },

                ModStone() to { it: Modifier ->
                    it.addItem("minecraft:stone".toItemStack!!.item)
                }

                */
        )
    }
}

//it.addItem("minecraft:stick".toItemStack!!.item)
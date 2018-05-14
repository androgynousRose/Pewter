package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.modifiers.ModStick
import slimeknights.tconstruct.tools.modifiers.ToolModifier

object TinkerModifiers {
    val modifiers = mapOf<ToolModifier, ToolModifier.() -> Unit>(
            ModStick() to { it: ToolModifier ->
                it.addItem("minecraft:stick".toItemStack!!.item)
            }
    )
}
package com.ejektaflex.pewter.modifiers

import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.tools.modifiers.ToolModifier

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterToolMod(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : ToolModifier(identifier, color) {
    open val motto = "Pewter Trait Motto Goes Here"
    open val description = "Pewter Modifier Description Goes Here."
    init {
        Pewter.LOGGER.info("Creating modifier: $name")
        MinecraftForge.EVENT_BUS.register(this)
    }
}
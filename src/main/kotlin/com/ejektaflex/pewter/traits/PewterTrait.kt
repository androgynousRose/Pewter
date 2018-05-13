package com.ejektaflex.pewter.traits

import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.traits.AbstractTrait

// This does not actually leak
@Suppress("LeakingThis")
open class PewterTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractTrait(identifier, color) {
    open val motto = "Pewter Trait Motto Goes Here"
    open val description = "Pewter Trait Description Goes Here."
    init {
        Pewter.LOGGER.info("Creating trait: $name")
        MinecraftForge.EVENT_BUS.register(this)
    }
}
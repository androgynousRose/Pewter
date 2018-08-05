package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.traits.AbstractTrait

// This does not actually leak
@Suppress("LeakingThis")
open class PewterTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractTrait(identifier, color) {
    init {
        Pewter.LOGGER.info("Creating trait: $name")
        TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}
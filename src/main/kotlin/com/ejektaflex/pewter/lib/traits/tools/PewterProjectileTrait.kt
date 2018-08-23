package com.ejektaflex.pewter.lib.traits.tools

import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait

// This does not actually leak
@Suppress("LeakingThis")
open class PewterProjectileTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractProjectileTrait(identifier, color) {
    init {
        Pewter.LOGGER.info("Creating trait: $name")
        TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}
package com.ejektaflex.pewter.traits.armor

import c4.conarm.lib.traits.AbstractArmorTrait
import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.traits.AbstractTrait

// This does not actually leak
@Suppress("LeakingThis")
open class PewterArmorTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractArmorTrait(identifier, color) {
    init {
        Pewter.LOGGER.info("Creating trait: $name (identifier: $identifier)")
        TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}
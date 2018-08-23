package com.ejektaflex.pewter.lib.traits.armor

import c4.conarm.lib.traits.AbstractArmorTrait
import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import slimeknights.tconstruct.library.TinkerRegistry

// This does not actually leak
@Suppress("LeakingThis")
open class PewterArmorTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractArmorTrait(identifier, color) {
    init {
        if (Loader.isModLoaded("conarm")) {
            Pewter.LOGGER.info("Creating trait: $name (identifier: $identifier)")
            TinkerRegistry.addTrait(this)
            MinecraftForge.EVENT_BUS.register(this)
        }
    }
}
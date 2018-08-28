package com.ejektaflex.pewter.lib.traits.tools

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.lib.mixins.ConfigurableModifier
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.ModifierTrait
import slimeknights.tconstruct.library.traits.AbstractTrait

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterToolTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : ModifierTrait(identifier, color) {
    init {
        Pewter.LOGGER.info("Creating trait: $name")
        TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}

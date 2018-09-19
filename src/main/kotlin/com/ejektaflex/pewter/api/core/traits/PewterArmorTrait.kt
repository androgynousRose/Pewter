package com.ejektaflex.pewter.api.core.traits

import c4.conarm.lib.traits.AbstractArmorTrait
import com.ejektaflex.pewter.api.PewterAPI
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import slimeknights.tconstruct.library.TinkerRegistry

/**
 * Extend this if you want to create a new Armor trait.
 */
@Suppress("LeakingThis")
open class PewterArmorTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractArmorTrait(identifier, color) {
    init {
        if (Loader.isModLoaded("conarm")) {
            PewterAPI.log("Creating trait: $name (identifier: $identifier)")
            TinkerRegistry.addTrait(this)
            MinecraftForge.EVENT_BUS.register(this)
        }
    }
}
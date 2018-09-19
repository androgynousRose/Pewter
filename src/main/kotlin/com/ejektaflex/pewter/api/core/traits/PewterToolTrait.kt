package com.ejektaflex.pewter.api.core.traits

import com.ejektaflex.pewter.api.PewterAPI
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.modifiers.ModifierTrait

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterToolTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' })
    : ModifierTrait(identifier, color), IPewterToolTrait {
    init {
        PewterAPI.log("Creating trait: $name")
        //TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}

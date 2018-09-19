package com.ejektaflex.pewter.api.core.traits

import com.ejektaflex.pewter.api.PewterAPI
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.traits.AbstractProjectileTrait

// This does not actually leak
@Suppress("LeakingThis")
open class PewterProjectileTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' }) : AbstractProjectileTrait(identifier, color) {
    init {
        PewterAPI.log("Creating trait: $name")
        //TinkerRegistry.addTrait(this)
        MinecraftForge.EVENT_BUS.register(this)
    }
}
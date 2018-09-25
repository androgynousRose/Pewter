package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import slimeknights.mantle.pulsar.pulse.Pulse

//@Pulse(identifier = TinkerWorld.PulseId, description = "Everything that's found in the world and worldgen")
abstract class PewterPulse {

    val materials = mutableListOf<MaterialDSL>()

    val toolTraits = mutableListOf<IPewterToolTrait>()

    val toolModifiers = mutableListOf<IPewterToolModifier>()

    val armorTraits = mutableListOf<IPewterArmorTrait>()

    val armorModifiers = mutableListOf<IPewterArmorModifier>()

}
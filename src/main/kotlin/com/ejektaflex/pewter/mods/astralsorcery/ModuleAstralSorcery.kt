package com.ejektaflex.pewter.mods.astralsorcery

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.astralsorcery.MaterialStarmetal
import com.ejektaflex.pewter.mods.astralsorcery.ArmorModAquaStarseeker
import com.ejektaflex.pewter.mods.astralsorcery.ToolModAquaCelestial
import com.ejektaflex.pewter.mods.astralsorcery.ToolTraitBrilliance

class ModuleAstralSorcery : PewterModule() {

    override val id = "astralsorcery"

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            EffectWrapper("starseeker_armor") { ArmorModAquaStarseeker(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialStarmetal("starmetal")
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            EffectWrapper("celestial") { ToolModAquaCelestial(this) }
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("brilliance") { ToolTraitBrilliance("brilliance") }
    )

}


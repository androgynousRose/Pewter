package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.thaumcraft.material.MaterialThaumium
import com.ejektaflex.pewter.mods.thaumcraft.material.MaterialVoidMetal
import com.ejektaflex.pewter.mods.thaumcraft.armor.ArmorTraitManiacal
import com.ejektaflex.pewter.mods.thaumcraft.armor.ArmorTraitVisBarrier
import com.ejektaflex.pewter.mods.thaumcraft.tool.*

class ModuleThaumcraft : PewterModule() {

    override val id = "thaumcraft"

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("maniacal") { ArmorTraitManiacal(this) },
            EffectWrapper("visbarrier") { ArmorTraitVisBarrier(this) }
    )

    override val materials = mutableListOf<MaterialDSL>(
            MaterialThaumium("thaumium"),
            MaterialVoidMetal("voidmetal")
    )

    override val toolModifiers = mutableListOf<EffectWrapper<out IPewterToolModifier>>(
            EffectWrapper("sanitizing") { ToolModSanitizing(this) },
            EffectWrapper("quicksilver") { ToolModQuicksilver(this) }
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("aural") { ToolTraitAural(this) },
            EffectWrapper("essentia") { ToolTraitEssentia(this) },
            EffectWrapper("polluted") { ToolTraitPolluted(this) },
            EffectWrapper("sapping") { ToolTraitSapping(this) },
            EffectWrapper("warping") { ToolTraitWarping(this) }
    )

}


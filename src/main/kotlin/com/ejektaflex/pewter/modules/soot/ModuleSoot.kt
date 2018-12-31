package com.ejektaflex.pewter.modules.soot

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait

class ModuleSoot : PewterModule() {

    override val id = "soot"

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("squelching") { ArmorTraitSquelching(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialAntimony("antimony")
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("quenching") { ToolTraitQuenching(this) }
    )

}


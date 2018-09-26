package com.ejektaflex.pewter.modules.specific

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.module.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.thebetweenlands.*

class ModuleTheBetweenlands : PewterModule() {

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitCorrosive(),
            ArmorTraitSplash()
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialDragonfly(),
            MaterialOctine(),
            MaterialSyrmorite(),
            MaterialValonite(),
            MaterialWeedwood()
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitBuzzing(),
            ToolTraitCorrosive(),
            ToolTraitGritty(),
            ToolTraitSparking()
    )

}


package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.thebetweenlands.armor.ArmorTraitCorrosive
import com.ejektaflex.pewter.mods.thebetweenlands.armor.ArmorTraitSplash
import com.ejektaflex.pewter.mods.thebetweenlands.material.*
import com.ejektaflex.pewter.mods.thebetweenlands.tool.ToolTraitBuzzing
import com.ejektaflex.pewter.mods.thebetweenlands.tool.ToolTraitCorrosive
import com.ejektaflex.pewter.mods.thebetweenlands.tool.ToolTraitGritty
import com.ejektaflex.pewter.mods.thebetweenlands.tool.ToolTraitSparking

class ModuleTheBetweenlands : PewterModule() {

    override val id = "thebetweenlands"

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


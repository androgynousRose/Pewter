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
            ArmorTraitCorrosive("corrosive"),
            ArmorTraitSplash("splash")
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialDragonfly("dragonflywing"),
            MaterialOctine("octine"),
            MaterialSyrmorite("syrmorite"),
            MaterialValonite("valonite"),
            MaterialWeedwood("weedwood")
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitBuzzing("buzzing"),
            ToolTraitCorrosive("corrosive"),
            ToolTraitGritty("gritty"),
            ToolTraitSparking("sparking")
    )

}


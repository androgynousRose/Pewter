package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
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

    override val armorTraits: MutableList<ModifierFunc<out IPewterArmorTrait>> = mutableListOf(
            ModifierFunc("corrosive") { ArmorTraitCorrosive(this) },
            ModifierFunc("splash") { ArmorTraitSplash(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialDragonfly("dragonflywing"),
            MaterialOctine("octine"),
            MaterialSyrmorite("syrmorite"),
            MaterialValonite("valonite"),
            MaterialWeedwood("weedwood")
    )

    override val toolTraits: MutableList<ModifierFunc<out IPewterToolTrait>> = mutableListOf(
            ModifierFunc("buzzing") { ToolTraitBuzzing(this) },
            ModifierFunc("corrosive") { ToolTraitCorrosive(this) },
            ModifierFunc("gritty") { ToolTraitGritty(this) },
            ModifierFunc("sparking") { ToolTraitSparking(this) }
    )

}


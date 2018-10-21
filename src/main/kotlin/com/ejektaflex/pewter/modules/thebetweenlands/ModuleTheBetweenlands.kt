package com.ejektaflex.pewter.modules.thebetweenlands

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.modules.thebetweenlands.armor.ArmorTraitCorrosive
import com.ejektaflex.pewter.modules.thebetweenlands.armor.ArmorTraitSplash
import com.ejektaflex.pewter.modules.thebetweenlands.material.*
import com.ejektaflex.pewter.modules.thebetweenlands.tool.ToolTraitBuzzing
import com.ejektaflex.pewter.modules.thebetweenlands.tool.ToolTraitCorrosive
import com.ejektaflex.pewter.modules.thebetweenlands.tool.ToolTraitGritty
import com.ejektaflex.pewter.modules.thebetweenlands.tool.ToolTraitSparking

class ModuleTheBetweenlands : PewterModule() {

    override val id = "thebetweenlands"

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("corrosive") { ArmorTraitCorrosive(this) },
            EffectWrapper("splash") { ArmorTraitSplash(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialDragonfly("dragonflywing"),
            MaterialOctine("octine"),
            MaterialSyrmorite("syrmorite"),
            MaterialValonite("valonite"),
            MaterialWeedwood("weedwood")
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            EffectWrapper("buzzing") { ToolTraitBuzzing(this) },
            EffectWrapper("corrosive") { ToolTraitCorrosive(this) },
            EffectWrapper("gritty") { ToolTraitGritty(this) },
            EffectWrapper("sparking") { ToolTraitSparking(this) }
    )

}


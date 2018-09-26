package com.ejektaflex.pewter.modules.specific

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.module.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.botania.*
import com.ejektaflex.pewter.mods.thebetweenlands.*

class ModuleBotania : PewterModule() {

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            ModifierFunc("dragonstone_armor") { ArmorModDragonstone(this) },
            ModifierFunc("runemana_armor") { ArmorModRuneMana(this) }
    )

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitAdapting(),
            ArmorTraitManaInfused(),
            ArmorTraitTerra()
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialElementium(),
            MaterialLivingrock(),
            MaterialLivingwood(),
            MaterialManasteel(),
            MaterialManastring(),
            MaterialTerrasteel()
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            ModifierFunc("dragonstone") { ToolModDragonstone(this) },
            ModifierFunc("runeautumn") { ToolModRuneAutumn(this) },
            ModifierFunc("runemana") { ToolModRuneMana(this) }
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitManaHarvest(),
            ToolTraitManaInfused()
    )

}


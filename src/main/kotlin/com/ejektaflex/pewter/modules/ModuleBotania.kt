package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.botania.armor.*
import com.ejektaflex.pewter.mods.botania.material.*
import com.ejektaflex.pewter.mods.botania.tool.*

class ModuleBotania : PewterModule() {

    override val id = "botania"

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            ModifierFunc("dragonstone_armor") { ArmorModDragonstone(this) },
            ModifierFunc("runemana_armor") { ArmorModRuneMana(this) }
    )

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitAdapting("adapting"),
            ArmorTraitManaInfused("Mana Infused"),
            ArmorTraitTerra("terra")
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialElementium("elementium"),
            MaterialLivingrock("livingrock"),
            MaterialLivingwood("livingwood"),
            MaterialManasteel("manasteel"),
            MaterialManastring("manastring"),
            MaterialTerrasteel("terrasteel")
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            ModifierFunc("dragonstone") { ToolModDragonstone(this) },
            ModifierFunc("runeautumn") { ToolModRuneAutumn(this) },
            ModifierFunc("runemana") { ToolModRuneMana(this) }
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitManaHarvest("manaharvest"),
            ToolTraitManaInfused("manainfused")
    )

}


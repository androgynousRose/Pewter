package com.ejektaflex.pewter.modules.common

import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.module.PewterModule
import com.ejektaflex.pewter.mods.commongems.armor.*
import com.ejektaflex.pewter.mods.commongems.tool.*

// Just a base for creating new modules; We never use this or extend it
class ModuleCommonGems : PewterModule() {

    override val armorModifiers: MutableList<ModifierFunc<out IPewterArmorModifier>> = mutableListOf(
            ModifierFunc("amber_armor") { ArmorModAmber(this) },
            ModifierFunc("amethyst_armor") { ArmorModAmethyst(this) },
            ModifierFunc("malachite_armor") { ArmorModMalachite(this) },
            ModifierFunc("peridot_armor") { ArmorModPeridot(this) },
            ModifierFunc("ruby_armor") { ArmorModRuby(this) },
            ModifierFunc("sapphire_armor") { ArmorModSapphire(this) },
            ModifierFunc("tanzanite_armor") { ArmorModTanzanite(this) },
            ModifierFunc("topaz_armor") { ArmorModTopaz(this) }
    )

    override val toolModifiers: MutableList<ModifierFunc<out IPewterToolModifier>> = mutableListOf(
            ModifierFunc("amber") { ToolModAmber(this) },
            ModifierFunc("amethyst") { ToolModAmethyst(this) },
            ModifierFunc("malachite") { ToolModMalachite(this) },
            ModifierFunc("peridot") { ToolModPeridot(this) },
            ModifierFunc("ruby") { ToolModRuby(this) },
            ModifierFunc("sapphire") { ToolModSapphire(this) },
            ModifierFunc("tanzanite") { ToolModTanzanite(this) },
            ModifierFunc("topaz") { ToolModTopaz(this) }
    )

}


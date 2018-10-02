package com.ejektaflex.pewter.modules.common

import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.mods.commongems.armor.*
import com.ejektaflex.pewter.mods.commongems.tool.*

class ModuleCommonGems : PewterModule() {

    override val id = "commonGems"

    override fun hasMetDependencies(): Boolean {
        return true
    }

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            EffectWrapper("amber_armor") { ArmorModAmber(this) },
            EffectWrapper("amethyst_armor") { ArmorModAmethyst(this) },
            EffectWrapper("malachite_armor") { ArmorModMalachite(this) },
            EffectWrapper("peridot_armor") { ArmorModPeridot(this) },
            EffectWrapper("ruby_armor") { ArmorModRuby(this) },
            EffectWrapper("sapphire_armor") { ArmorModSapphire(this) },
            EffectWrapper("tanzanite_armor") { ArmorModTanzanite(this) },
            EffectWrapper("topaz_armor") { ArmorModTopaz(this) }
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            EffectWrapper("amber") { ToolModAmber(this) },
            EffectWrapper("amethyst") { ToolModAmethyst(this) },
            EffectWrapper("malachite") { ToolModMalachite(this) },
            EffectWrapper("peridot") { ToolModPeridot(this) },
            EffectWrapper("ruby") { ToolModRuby(this) },
            EffectWrapper("sapphire") { ToolModSapphire(this) },
            EffectWrapper("tanzanite") { ToolModTanzanite(this) },
            EffectWrapper("topaz") { ToolModTopaz(this) }
    )

}


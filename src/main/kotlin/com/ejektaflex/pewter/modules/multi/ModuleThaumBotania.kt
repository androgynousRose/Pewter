package com.ejektaflex.pewter.modules.multi

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.common.magic.ArmorTraitMagical
import com.ejektaflex.pewter.mods.common.magic.MaterialMagicalFabric
import net.minecraftforge.fml.common.Loader

class ModuleThaumBotania : PewterModule() {

    override val id = "thaumcraft_or_botania"

    override fun hasMetDependencies(): Boolean {
        return Loader.isModLoaded("thaumcraft") || Loader.isModLoaded("botania")
    }

    override val armorModifiers: MutableList<EffectWrapper<out IPewterArmorModifier>> = mutableListOf(
            // None
    )

    override val armorTraits: MutableList<EffectWrapper<out IPewterArmorTrait>> = mutableListOf(
            EffectWrapper("magical") { ArmorTraitMagical(this) }
    )

    override val materials: MutableList<MaterialDSL> = mutableListOf(
            MaterialMagicalFabric("magical_fabric")
    )

    override val toolModifiers: MutableList<EffectWrapper<out IPewterToolModifier>> = mutableListOf(
            // None
    )

    override val toolTraits: MutableList<EffectWrapper<out IPewterToolTrait>> = mutableListOf(
            // None
    )

}


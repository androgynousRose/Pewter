package com.ejektaflex.pewter.modules

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.thaumcraft.material.MaterialThaumium
import com.ejektaflex.pewter.mods.thaumcraft.material.MaterialVoidMetal
import com.ejektaflex.pewter.mods.thaumcraft.armor.ArmorTraitManiacal
import com.ejektaflex.pewter.mods.thaumcraft.armor.ArmorTraitVisBarrier
import com.ejektaflex.pewter.mods.thaumcraft.tool.*

class ModuleThaumcraft : PewterModule() {

    override val id = "thaumcraft"

    override val armorTraits: MutableList<IPewterArmorTrait> = mutableListOf(
            ArmorTraitManiacal(),
            ArmorTraitVisBarrier()
    )

    override val materials = mutableListOf<MaterialDSL>(
            MaterialThaumium(),
            MaterialVoidMetal()
    )

    override val toolModifiers = mutableListOf<ModifierFunc<out IPewterToolModifier>>(
            ModifierFunc("sanitizing") { ToolModSanitizing(this) },
            ModifierFunc("quicksilver") { ToolModQuicksilver(this) }
    )

    override val toolTraits: MutableList<IPewterToolTrait> = mutableListOf(
            ToolTraitAural(),
            ToolTraitEssentia(),
            ToolTraitPolluted(),
            ToolTraitSapping(),
            ToolTraitWarping()
    )

}


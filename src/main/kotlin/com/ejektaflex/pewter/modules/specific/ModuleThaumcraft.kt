package com.ejektaflex.pewter.modules.specific

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.module.PewterModule
import com.ejektaflex.pewter.api.core.traits.IPewterArmorTrait
import com.ejektaflex.pewter.api.core.traits.IPewterToolTrait
import com.ejektaflex.pewter.mods.thaumcraft.MaterialThaumium
import com.ejektaflex.pewter.mods.thaumcraft.MaterialVoidMetal
import com.ejektaflex.pewter.mods.thaumcraft.ToolModQuicksilver
import com.ejektaflex.pewter.mods.thaumcraft.*

class ModuleThaumcraft : PewterModule() {

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


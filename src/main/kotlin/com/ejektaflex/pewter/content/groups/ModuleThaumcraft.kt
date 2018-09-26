package com.ejektaflex.pewter.content.groups

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.modifiers.ModifierFunc
import com.ejektaflex.pewter.api.core.pulse.PewterModule
import com.ejektaflex.pewter.materials.thaumcraft.ThaumiumMaterial
import com.ejektaflex.pewter.materials.thaumcraft.VoidMetalMaterial
import com.ejektaflex.pewter.modifiers.tools.ModQuicksilver
import com.ejektaflex.pewter.modifiers.tools.ModSanitizing

class ModuleThaumcraft : PewterModule() {

    override val materials = mutableListOf<MaterialDSL>(
            ThaumiumMaterial(),
            VoidMetalMaterial()
    )

    override val toolModifiers = mutableListOf<ModifierFunc<out IPewterToolModifier>>(
            ModifierFunc("sanitizing") { ModSanitizing(this) },
            ModifierFunc("quicksilver") { ModQuicksilver(this) }
    )

}


package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.modifiers.armor.ArmorModAmber
import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers : IPewterContent<Modifier> {
    override val content: List<Modifier> by lazy {
        // Regular Modifiers
        val mods = mutableListOf<Modifier>(
                // Thaumcraft
                ModSanitizing(),
                // Biomes O' Plenty
                ModEnderAmethyst(),
                ModRuby(),
                ModPeridot(),
                ModTopaz(),
                ModTanzanite(),
                ModMalachite(),
                ModSapphire(),
                ModAmber()
        )

        // Construct's Armory Integration
        if (Pewter.CONFIG.MAIN.conarmIntegration) {
            mods += mutableListOf<Modifier>(
                    ArmorModAmber()
            )
        }

        return@lazy mods
    }
}

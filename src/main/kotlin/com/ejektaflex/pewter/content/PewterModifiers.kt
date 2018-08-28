package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.modifiers.armor.*
import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers : IPewterContent<Modifier> {
    override val content: List<Modifier> by lazy {
        // Regular Modifiers
        val mods = mutableListOf<Modifier>(
                // Thaumcraft
                ModSanitizing(),
                // Biomes O' Plenty
                ModAmethyst(),
                ModRuby(),
                ModPeridot(),
                ModTopaz(),
                ModTanzanite(),
                ModMalachite(),
                ModSapphire(),
                ModAmber(),
                // Botania
                ModRuneMana(),
                ModRuneAutumn(),
                ModDragonstone()
        )

        // Construct's Armory Integration
        if (Pewter.CONFIG.MAIN.conarmIntegration) {
            mods += mutableListOf<Modifier>(
                    // Biomes O' Plenty
                    ArmorModAmber(),
                    ArmorModAmethyst(),
                    ArmorModMalachite(),
                    ArmorModPeridot(),
                    ArmorModRuby(),
                    ArmorModSapphire(),
                    ArmorModTanzanite(),
                    ArmorModTopaz(),
                    // Botania
                    ArmorModRuneMana()
            )
        }

        return@lazy mods
    }
}

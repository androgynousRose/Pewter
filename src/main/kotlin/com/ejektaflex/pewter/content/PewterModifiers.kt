package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.modifiers.armor.*
import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers : IPewterContent<Modifier> {

    override fun get(id: String): Modifier? {
        return content.find { it.identifier == id }
    }

    val contentMap: Map<String, (it: String) -> Modifier>
        get() = mutableMapOf<String, (it: String) -> Modifier>(
                // Biomes O' Plenty
                "amber_armor" to { it -> ArmorModAmber(it) },
                "amethyst_armor" to { it -> ArmorModAmethyst(it) },
                "ruby_armor" to { it -> ArmorModRuby(it) },
                "malachite_armor" to { it -> ArmorModMalachite(it) },
                "peridot_armor" to { it -> ArmorModPeridot(it) },
                "sapphire_armor" to {it -> ArmorModSapphire(it) },
                "tanzanite_armor" to { it -> ArmorModTanzanite(it) },
                "topaz_armor" to { it -> ArmorModTopaz(it) },

                "amethyst" to { it -> ModAmethyst(it) },
                "ruby" to { it -> ModRuby(it) },
                "peridot" to { it -> ModPeridot(it) },
                "topaz" to { it -> ModTopaz(it) },
                "tanzanite" to { it -> ModTanzanite(it) },
                "malachite" to { it -> ModMalachite(it) },
                "sapphire" to { it -> ModSapphire(it) },
                "amber" to {it -> ModAmber(it) },

                // Thaumcraft
                "sanitizing" to { it -> ModSanitizing(it) },
                "quicksilver" to { it -> ModQuicksilver(it) },



                "runemana" to { it -> ModRuneMana(it) },
                "runeautumn" to { it -> ModRuneAutumn(it) },
                "dragonstone" to { it -> ModDragonstone(it) },

                "runemana_armor" to { it -> ArmorModSapphire(it) },
                "dragonstone_armor" to { it -> ArmorModDragonstone(it) }
        ).mapNotNull {

            // Remove modifiers that have been blacklisted
            if (Pewter.hasBlacklistedModifier(it.key)) {
                return@mapNotNull null
            }

            // Remove conarm mods if the mod isn't loaded
            if (it.key.endsWith("_armor")) {
                if (Pewter.isUsingConArm()) {
                    it.key to it.value
                } else {
                    return@mapNotNull null
                }
            }

            it.key to it.value
        }.toMap()


    override val content: List<Modifier> by lazy {

        // Remove _armor on armor traits (they get re-added on Armor modifier init)
        val modMapping = contentMap.map {
            if (it.key.endsWith("_armor")) {
                it.value(it.key.dropLast("_armor".length))
            } else {
                it.value(it.key)
            }
        }

        return@lazy modMapping
    }
}

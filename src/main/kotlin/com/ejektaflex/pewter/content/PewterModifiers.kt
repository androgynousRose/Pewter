package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.modifiers.armor.*
import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers : IPewterContent<Modifier> {

    private const val armorSuffix = "_armor"

    override fun get(id: String): Modifier? {
        return content.find { it.identifier == id }
    }

    private var preloadedContent: List<ModifierDef<*>> = mutableListOf(
            // Biomes O' Plenty

            // Armor
            ModifierDef("amber_armor", ::ArmorModAmber),
            ModifierDef("amethyst_armor", ::ArmorModAmethyst),
            ModifierDef("ruby_armor", ::ArmorModRuby),
            ModifierDef("malachite_armor", ::ArmorModMalachite),
            ModifierDef("peridot_armor", ::ArmorModPeridot),
            ModifierDef("sapphire_armor", ::ArmorModSapphire),
            ModifierDef("tanzanite_armor", ::ArmorModTanzanite),
            ModifierDef("topaz_armor", ::ArmorModTopaz),
            //Tools
            ModifierDef("amethyst", ::ModAmethyst),
            ModifierDef("ruby", ::ModRuby),
            ModifierDef("peridot", ::ModPeridot),
            ModifierDef("topaz", ::ModTopaz),
            ModifierDef("tanzanite", ::ModTanzanite),
            ModifierDef("malachite", ::ModMalachite),
            ModifierDef("sapphire", ::ModSapphire),
            ModifierDef("amber", ::ModAmber),

            // Thaumcraft

            // Tools
            ModifierDef("sanitizing", ::ModSanitizing),
            ModifierDef("quicksilver", ::ModQuicksilver),

            // Botania

            // Armor
            ModifierDef("runemana_armor", ::ArmorModRuneMana),
            ModifierDef("dragonstone_armor", ::ArmorModDragonstone),

            // Tools
            ModifierDef("runemana", ::ModRuneMana),
            ModifierDef("runeautumn", ::ModRuneAutumn),
            ModifierDef("dragonstone", ::ModDragonstone)
    )

    val contentDefs: List<ModifierDef<*>>
        get() = preloadedContent.mapNotNull {
            // Remove modifiers that have been blacklisted
            if (Pewter.hasBlacklistedModifier(it.name)) {
                return@mapNotNull null
            }

            // Remove ConArm mods if the mod isn't loaded
            if (it.name.endsWith(armorSuffix) && !Pewter.isUsingConArm()) {
                return@mapNotNull null
            }

            it
        }

    override val content: List<Modifier> by lazy {
        return@lazy contentDefs.map {

            if (it.name.endsWith(armorSuffix)) {
                it.name = it.name.dropLast(armorSuffix.length)
            }

            it.create()
        }
    }

}

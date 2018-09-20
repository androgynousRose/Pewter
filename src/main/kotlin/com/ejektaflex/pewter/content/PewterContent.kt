package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.materials.astralsorcery.StarmetalMaterial
import com.ejektaflex.pewter.materials.betterwithmods.HellfireMaterial
import com.ejektaflex.pewter.materials.betterwithmods.SoulforgedSteelMaterial
import com.ejektaflex.pewter.materials.betweenlands.*
import com.ejektaflex.pewter.materials.botania.*
import com.ejektaflex.pewter.materials.thaumcraft.ThaumiumMaterial
import com.ejektaflex.pewter.materials.thaumcraft.VoidMetalMaterial
import com.ejektaflex.pewter.modifiers.armor.*
import com.ejektaflex.pewter.modifiers.tools.*
import com.ejektaflex.pewter.traits.armor.*
import com.ejektaflex.pewter.traits.tools.*

object PewterContent {

    private val materials = listOf(
            // Astral Sorcery
            StarmetalMaterial(),
            // Better With Mods
            HellfireMaterial(),
            SoulforgedSteelMaterial(),
            // The Betweenlands
            OctineMaterial(),
            SyrmoriteMaterial(),
            DragonflyMaterial(),
            ValoniteMaterial(),
            WeedwoodMaterial(),
            // Botania
            ManasteelMaterial(),
            ManastringMaterial(),
            TerrasteelMaterial(),
            ElementiumMaterial(),
            LivingwoodMaterial(),
            LivingrockMaterial(),
            // Thaumcraft
            ThaumiumMaterial(),
            VoidMetalMaterial()
    )

    private val armorModifiers = listOf(
            // BOP
            ModifierDef("amber_armor", ::ArmorModAmber),
            ModifierDef("amethyst_armor", ::ArmorModAmethyst),
            ModifierDef("ruby_armor", ::ArmorModRuby),
            ModifierDef("malachite_armor", ::ArmorModMalachite),
            ModifierDef("peridot_armor", ::ArmorModPeridot),
            ModifierDef("sapphire_armor", ::ArmorModSapphire),
            ModifierDef("tanzanite_armor", ::ArmorModTanzanite),
            ModifierDef("topaz_armor", ::ArmorModTopaz),
            // Botania
            ModifierDef("runemana_armor", ::ArmorModRuneMana),
            ModifierDef("dragonstone_armor", ::ArmorModDragonstone)
    )

    private val toolModifiers = mutableListOf(
            // BOP
            ModifierDef("amethyst", ::ModAmethyst),
            ModifierDef("ruby", ::ModRuby),
            ModifierDef("peridot", ::ModPeridot),
            ModifierDef("topaz", ::ModTopaz),
            ModifierDef("tanzanite", ::ModTanzanite),
            ModifierDef("malachite", ::ModMalachite),
            ModifierDef("sapphire", ::ModSapphire),
            ModifierDef("amber", ::ModAmber),
            // Thaumcraft
            ModifierDef("sanitizing", ::ModSanitizing),
            ModifierDef("quicksilver", ::ModQuicksilver),
            // Botania
            ModifierDef("runemana", ::ModRuneMana),
            ModifierDef("runeautumn", ::ModRuneAutumn),
            ModifierDef("dragonstone", ::ModDragonstone)
    )

    private val toolTraits: MutableList<out IPewterTrait> by lazy {
        mutableListOf<IPewterTrait>(
                Brilliance(),
                Buzzing(),
                HeatLover(),
                Polluted(),
                Essentia(),
                Aural(),
                Warping(),
                Sapping(),
                Corrosive(),
                Sparking(),
                Gritty(),
                Heavyweight(),
                Attuned(),
                ManaInfused(),
                Basher(),
                ManaHarvest()
        )
    }

    private val armorTraits: MutableList<out IPewterTrait> by lazy {
        mutableListOf<IPewterTrait>(
                ArmorHeatLover(),
                ArmorInflamed(),
                ArmorCorrosive(),
                ArmorVisBarrier(),
                ArmorManiacal(),
                ArmorSplash(),
                ArmorManaInfused(),
                ArmorAdapting(),
                ArmorEnvious(),
                ArmorTerra()
        )
    }


    fun load() {

        for (trait in toolTraits) {
            PewterAPI.addToolTrait(trait)
        }

        for (trait in armorTraits) {
            if (Pewter.isUsingConArm()) {
                PewterAPI.addArmorTrait(trait)
            } else {
                PewterAPI.log("Pewter is not using ConArm; Skipping internal ConArm modifiers")
            }
        }

        for (mod in toolModifiers) {
            PewterAPI.addToolModifier(mod)
        }

        for (mod in armorModifiers) {
            if (Pewter.isUsingConArm()) {
                PewterAPI.addArmorModifier(mod)
            } else {
                PewterAPI.log("Pewter is not using ConArm; Skipping internal ConArm modifiers")
            }
        }

        for (mat in materials) {
            PewterAPI.addMaterial(mat)
        }

        PewterTraits.setup()
        PewterModifiers.setup()
        PewterMaterials.setup()

    }

}
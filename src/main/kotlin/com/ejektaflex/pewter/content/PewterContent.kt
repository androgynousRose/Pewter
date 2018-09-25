package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.api.modifiers.ModifierFunc
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
            // General gems
            ModifierFunc("amber_armor") { ArmorModAmber(this) },
            ModifierFunc("amethyst_armor") { ArmorModAmethyst(this) },
            ModifierFunc("ruby_armor") { ArmorModRuby(this) },
            ModifierFunc("malachite_armor") { ArmorModMalachite(this) },
            ModifierFunc("peridot_armor") { ArmorModPeridot(this) },
            ModifierFunc("sapphire_armor") { ArmorModSapphire(this) },
            ModifierFunc("tanzanite_armor") { ArmorModTanzanite(this) },
            ModifierFunc("topaz_armor") { ArmorModTopaz(this) },

            // Botania
            ModifierFunc("runemana_armor") { ArmorModRuneMana(this) },
            ModifierFunc("dragonstone_armor") { ArmorModDragonstone(this) },

            // Astral Sorcery
            ModifierFunc("starseeker_armor") { ArmorModAquaStarseeker(this) }
    )

    private val toolModifiers = mutableListOf<ModifierFunc<IPewterToolModifier>>(
            // BOP
            ModifierFunc("amethyst") { ModAmethyst(this) },
            ModifierFunc("ruby") { ModRuby(this) },
            ModifierFunc("peridot") { ModPeridot(this) },
            ModifierFunc("topaz") { ModTopaz(this) },
            ModifierFunc("tanzanite") { ModTanzanite(this) },
            ModifierFunc("malachite") { ModMalachite(this) },
            ModifierFunc("sapphire") { ModSapphire(this) },
            ModifierFunc("amber") { ModAmber(this) },
            // Thaumcraft
            ModifierFunc("sanitizing") { ModSanitizing(this) },
            ModifierFunc("quicksilver") { ModQuicksilver(this) },
            // Botania
            ModifierFunc("runemana") { ModRuneMana(this) },
            ModifierFunc("runeautumn") { ModRuneAutumn(this) },
            ModifierFunc("dragonstone") { ModDragonstone(this) },
            // Astral Sorcery
            ModifierFunc("celestial") { ModAquaCelestial(this) }
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
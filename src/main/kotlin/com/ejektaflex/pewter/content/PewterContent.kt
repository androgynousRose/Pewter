package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.pulse.PewterModule
import com.ejektaflex.pewter.content.groups.ModuleThaumcraft

internal object PewterContent {

    private val modules = mutableListOf<PewterModule>()

    fun registerModule(module: PewterModule) {
        modules.add(module)
    }

    init {
        val builtins = listOf<PewterModule>(
                ModuleThaumcraft()
        )

        for (builtinModule in builtins) {
            registerModule(builtinModule)
        }
    }

    /*
    override val materials = mutableListOf(
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
    */

    /*

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

    */

    fun load() {

        for (module in modules) {
            loadModule(module)
        }

        PewterTraits.setup()
        PewterModifiers.setup()
        PewterMaterials.setup()

    }

    private fun loadModule(module: PewterModule) {
        for (trait in module.toolTraits) {
            PewterAPI.addToolTrait(trait)
        }

        for (mod in module.toolModifiers) {
            PewterAPI.addToolModifier(mod)
        }

        for (mat in module.materials) {
            PewterAPI.addMaterial(mat)
        }

        if (Pewter.isUsingConArm()) {
            for (trait in module.armorTraits) {
                PewterAPI.addArmorTrait(trait)
            }

            for (mod in module.armorModifiers) {
                PewterAPI.addArmorModifier(mod)
            }
        }
    }

}
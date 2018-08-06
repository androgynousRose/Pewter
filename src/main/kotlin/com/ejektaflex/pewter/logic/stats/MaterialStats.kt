package com.ejektaflex.pewter.logic.stats

import c4.conarm.lib.materials.*
import com.ejektaflex.pewter.Pewter
import net.minecraftforge.fluids.Fluid
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.materials.*


class MaterialStats {
    var tool = ToolStats()

    var color = "#448844"
    var craftable = false
    var madeInToolForge = false
    var name = "doot"
    var createMeltingRecipes = true
    var meltingTemperature = 475
    var looks = mutableMapOf(
            "shininess" to 0.25f,
            "brightness" to 0.25f,
            "hueshift" to -0.1f
    )
    var fluidName: String? = null
    var fluid = mutableMapOf(
            "viscosity" to 8000,
            "density" to 1500,
            "temperature" to 1000,
            "luminosity" to 8
    )
    var matParts = mutableSetOf<MatPart>()
    var nameLocales = mutableMapOf<String, String>()
    var smelting = mutableMapOf<String, MutableList<String>>(
            "ingot" to mutableListOf(),
            "block" to mutableListOf(),
            "nugget" to mutableListOf(),
            "ore" to mutableListOf()
    )

    var armor: ArmorStats? = null

    var specificTraits = mutableMapOf<String, MutableList<String>>(

    )

    @Transient
    var isInCustomFolder = false

    fun registerStats(m: Material, part: MatPart) {
        if (part == MatPart.PROJECTILE) {
            // Quoting MrJohz/LakMoore:
            //Tinkers auto-adds this stat to any tinkMaterial used to make stats heads
            //and trying to add it a second time throws an exception, so check before adding.
            if(!m.hasStats(MaterialTypes.PROJECTILE)) {
                addStats(m, part)
            }
        } else {
            addStats(m, part)
        }
    }

    private fun addStats(m: Material, part: MatPart) {
        // If it's an armor part, only register if we have armor stats
        if (part.isArmorPart) {
            if (armor != null && Pewter.CONFIG.MAIN.conarmIntegration) {
                TinkerRegistry.addMaterialStats(m, part.stats(this))
            }
        } else {
            TinkerRegistry.addMaterialStats(m, part.stats(this))
        }

    }

    enum class MatPart(val dependency: String, val stats: (it: MaterialStats) -> IMaterialStats?, val isArmorPart: Boolean = false) {
        // Tools
        HEAD(MaterialTypes.HEAD, { HeadMaterialStats(it.tool.head.durability, it.tool.head.speed, it.tool.head.attackDamage, it.tool.head.harvestLevel) }),
        HANDLE(MaterialTypes.HANDLE, { HandleMaterialStats(it.tool.handle.modifier, it.tool.handle.durability) }),
        EXTRA(MaterialTypes.EXTRA, { ExtraMaterialStats(it.tool.extra.durability) }),
        BOW(MaterialTypes.BOW, { BowMaterialStats(it.tool.bow.speed, it.tool.bow.range, it.tool.bow.bonusDamage) }),
        SHAFT(MaterialTypes.SHAFT, { ArrowShaftMaterialStats(it.tool.arrowShaft.modifier, it.tool.arrowShaft.bonusAmmo) }),
        FLETCHING(MaterialTypes.FLETCHING, { FletchingMaterialStats(it.tool.fletching.accuracy, it.tool.fletching.modifier) }),
        BOWSTRING(MaterialTypes.BOWSTRING, { BowStringMaterialStats(it.tool.bowstring.modifier) }),
        PROJECTILE(MaterialTypes.PROJECTILE, { ProjectileMaterialStats() }),
        // Armor
        CORE("core", {
            CoreMaterialStats(it.armor?.core?.durability ?: 1f, it.armor?.core?.defense ?: 1f)
        }, isArmorPart = true),
        PLATES("plates", {
            PlatesMaterialStats(it.armor?.plates?.modifier ?: 1f, it.armor?.plates?.durability ?: 1f, it.armor?.plates?.toughness ?: 1f)
        }, isArmorPart = true),
        TRIM("trim", {
            TrimMaterialStats(it.armor?.trim?.extraDurability ?: 0f)
        }, isArmorPart = true)
    }

}
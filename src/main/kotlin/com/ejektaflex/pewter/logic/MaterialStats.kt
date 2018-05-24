package com.ejektaflex.pewter.logic

import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.materials.*


class MaterialStats {
    var color = "#448844"
    var craftable = false
    var madeInToolForge = false
    var name = "doot"
    var meltingTemperature = 475
    var durability = 0
    var toolAttackDamage = 0f
    var toolHarvestLevel = 0
    var toolSpeed = 0f
    var handleMult = 0f
    var handleDurability = 0
    var bindingDurability = 0
    var bowSpeed = 0f
    var bowAccuracy = 0f
    var bowRange = 0f
    var bowBonusDamage = 0f
    var arrowShaftModifier = 0f
    var arrowShaftBonusAmmo = 0
    var arrowFletchingModifier = 0f
    var bowStringModifier = 0f
    var defaultTrait = ""
    var looks = mutableMapOf(
            "shininess" to 0.25f,
            "brightness" to 0.25f,
            "hueshift" to -0.1f
    )
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
                TinkerRegistry.addMaterialStats(m, part.stats(this))
            }
        } else {
            TinkerRegistry.addMaterialStats(m, part.stats(this))
        }
    }

    enum class MatPart(val dependency: String, val stats: (it: MaterialStats) -> IMaterialStats?) {
        HEAD(MaterialTypes.HEAD, { HeadMaterialStats(it.durability, it.toolSpeed, it.toolAttackDamage, it.toolHarvestLevel) }),
        HANDLE(MaterialTypes.HANDLE, { HandleMaterialStats(it.handleMult, it.handleDurability) }),
        EXTRA(MaterialTypes.EXTRA, { ExtraMaterialStats(it.bindingDurability) }),
        BOW(MaterialTypes.BOW, { BowMaterialStats(it.bowSpeed, it.bowRange, it.bowBonusDamage) }),
        SHAFT(MaterialTypes.SHAFT, { ArrowShaftMaterialStats(it.arrowShaftModifier, it.arrowShaftBonusAmmo) }),
        FLETCHING(MaterialTypes.FLETCHING, { FletchingMaterialStats(it.bowAccuracy, it.arrowFletchingModifier) }),
        BOWSTRING(MaterialTypes.BOWSTRING, { BowStringMaterialStats(it.bowStringModifier) }),
        PROJECTILE(MaterialTypes.PROJECTILE, { ProjectileMaterialStats() })
    }

}
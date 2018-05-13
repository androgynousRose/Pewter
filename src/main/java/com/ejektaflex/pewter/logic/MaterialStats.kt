package com.ejektaflex.pewter.logic

import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.materials.*


class MaterialStats {
    var color = "#448844"
    var craftable = false
    var madeInToolForge = false
    var name = "doot"
    var durability = 0
    var toolAttackDamage = 0
    var toolHarvestLevel = 0
    var toolSpeed = 0f
    var handleMult = 0f
    var handleDurability = 0
    var bindingDurability = 0
    var bowAccuracy = 0f
    var bowRange = 0f
    var bowBonusDamage = 0f
    var arrowShaftModifier = 0f
    var arrowShaftBonusAmmo = 0
    var fletchingModifier = 0f
    var stringModifier = 0f
    var defaultTrait = "dense"
    var matParts = mutableSetOf<MatPart>()
    var nameLocales = mutableMapOf<String, String>()
    var smelting = mutableMapOf<String, MutableList<String>>(
            "ingot" to mutableListOf()
    )
    var specificTraits = mutableMapOf<String, MutableList<String>>(

    )
    
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
        HEAD(MaterialTypes.HEAD, { HeadMaterialStats(it.durability, it.toolSpeed, it.toolAttackDamage.toFloat(), it.toolHarvestLevel) }),
        HANDLE(MaterialTypes.HANDLE, { HandleMaterialStats(it.handleMult, it.handleDurability) }),
        BINDING(MaterialTypes.EXTRA, { ExtraMaterialStats(it.bindingDurability) }),
        BOW(MaterialTypes.BOW, { BowMaterialStats(it.toolSpeed, it.bowRange, it.bowBonusDamage) }),
        SHAFT(MaterialTypes.SHAFT, { ArrowShaftMaterialStats(it.arrowShaftModifier, it.arrowShaftBonusAmmo) }),
        FLETCHING(MaterialTypes.FLETCHING, { FletchingMaterialStats(it.bowAccuracy, it.fletchingModifier) }),
        BOWSTRING(MaterialTypes.BOWSTRING, { BowStringMaterialStats(it.stringModifier) }),
        PROJECTILE(MaterialTypes.PROJECTILE, { ProjectileMaterialStats() })
    }

}
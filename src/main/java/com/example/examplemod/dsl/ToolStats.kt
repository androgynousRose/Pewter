package com.example.examplemod.dsl

import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.materials.*


class ToolStats {
    var color = 0
    var craftable = false
    var madeInToolForge = false
    var toolId = 0
    var name = "doot"
    var durability = 0
    var attack = 0
    var matHarvest = 0
    var matSpeed = 0f
    var handleMult = 0f
    var handleDurability = 0
    var extraDurability = 0
    var bowAccuracy = 0f
    var bowRange = 0f
    var bowBonusDamage = 0f
    var arrowShaftModifier = 0f
    var arrowShaftBonusAmmo = 0
    var fletchingModifier = 0f
    var stringModifier = 0f
    var matParts = mutableListOf<MatPart>()

    /*
    private fun addTrait(name: String, matType: String) {
        val imod = TinkerRegistry.getModifier(name)
        if (imod != null && imod is ITrait) {
            if (matType == "") {
                material.addTrait(imod)
            } else {
                material.addTrait(imod, matType)
            }
        }
    }
    */

    // Quoting MrJohz/LakMoore:
    //Tinkers auto-adds this stat to any material used to make tool heads
    //and trying to add it a second time throws an exception, so check before adding.
    fun registerStats(m: Material, part: MatPart) {
        if (part == MatPart.PROJECTILE) {
            if(!m.hasStats(MaterialTypes.PROJECTILE)) {
                TinkerRegistry.addMaterialStats(m, part.stats(this))
            }
        } else {
            TinkerRegistry.addMaterialStats(m, part.stats(this))
        }
    }

    enum class MatPart(val stats: (it: ToolStats) -> IMaterialStats?) {
        HEAD({ HeadMaterialStats(it.durability, it.matSpeed, it.attack.toFloat(), it.matHarvest) }),
        HANDLE({ HandleMaterialStats(it.handleMult, it.handleDurability) }),
        BINDING({ ExtraMaterialStats(it.extraDurability) }),
        BOW({ BowMaterialStats(it.matSpeed, it.bowRange, it.bowBonusDamage) }),
        SHAFT({ ArrowShaftMaterialStats(it.arrowShaftModifier, it.arrowShaftBonusAmmo) }),
        FLETCHING({ FletchingMaterialStats(it.bowAccuracy, it.fletchingModifier) }),
        STRING({ BowStringMaterialStats(it.stringModifier) }),
        PROJECTILE({ ProjectileMaterialStats() })
    }

    override fun toString(): String {
        return "NAME: $name: DUR: $durability ATK: $attack SPD: $matSpeed"
    }


}
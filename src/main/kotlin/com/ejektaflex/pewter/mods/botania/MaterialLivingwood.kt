package com.ejektaflex.pewter.mods.botania

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BotaniaDependency
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData

class MaterialLivingwood : MaterialDSL("livingwood", "#401909", {
    forge { false }
    craft { true }
    ingots("botania:manaresource:3")
    defaultMetalParts()
    parts(MaterialData.MatPart.SHAFT)
    addTraits(
            //"HEAD" to "corrosive",
            "HEAD" to "ecological",
            //"HANDLE" to "corrosive",
            "HANDLE" to "ecological",
            //"EXTRA" to "corrosive",
            "EXTRA" to "ecological",
            //"BOW" to "corrosive",
            "BOW" to "ecological",
            //"SHAFT" to "corrosive",
            "SHAFT" to "ecological",
            //"PROJECTILE" to "corrosive",
            "PROJECTILE" to "ecological"
    )
    shininess(0f)
    brightness(0.15f)
    tool {
        toolTrait("manaharvest")

        head {
            durability { 50 }
            attack { 2f }
            speed { 2.25f }
            harvestLevel(0)
        }
        handle {
            durability { 35 }
            modifier { 1.15f }
        }
        extra {
            durability { 25 }
        }
        bow {
            speed(0.95f)
            range { 1.05f }
            bonusDamage { 1f }
        }

        shaft {
            modifier { 0.7f }
            bonusAmmo { 6 }
        }
    }

    armor {
        armorTrait("manaharvest_armor")
        armorTrait("ecological_armor")
        core {
            durability { 3f }
            defense { 3.5f }
        }
        plates {
            modifier { 1.05f }
            durability { 1.25f }
            toughness { 0f }
        }
        trim {
            extraDurability { 0.5f }
        }
    }


}), BotaniaDependency
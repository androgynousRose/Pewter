package com.ejektaflex.pewter.materials.betweenlands

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.BetweenlandsDependency
import com.ejektaflex.pewter.logic.stats.MaterialData

class WeedwoodMaterial : MaterialDSL("weedwood", "#665E31", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:weedwood_planks")
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
    shininess(0.15f)
    tool {

        toolTrait("corrosive")


        head {
            durability { 75 }
            attack { 2.2f }
            speed { 2.4f }
            harvestLevel(0)
        }
        handle {
            durability { 40 }
            modifier { 1.1f }
        }
        extra {
            durability { 25 }
        }
        bow {
            speed(0.95f)
            range { 0.9f }
            bonusDamage { -0.5f }
        }
        shaft {
            modifier { 0.8f }
        }
    }

    armor {
        armorTrait("ecological_armor")
        armorTrait("corrosive_armor")
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


}), BetweenlandsDependency
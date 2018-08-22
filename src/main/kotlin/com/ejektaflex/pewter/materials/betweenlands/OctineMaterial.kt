package com.ejektaflex.pewter.materials.betweenlands

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.BetweenlandsDependency

class OctineMaterial : MaterialDSL("octine", "#F38A20", {
    locale("en_7S " to "Ye Illuminating Treasure")
    forge { true }
    craft { false }
    ingots("thebetweenlands:octine_ingot")
    ores("thebetweenlands:octine_ore")
    defaultMetalParts()
    addTraits(
            //"HEAD" to "corrosive",
            "HEAD" to "sparking"
    )
    shininess(0.5f)
    tool {
        toolTrait("corrosive")

        head {
            durability { 270 }
            attack { 4.2f }
            speed { 5.5f }
            harvestLevel(1)
        }
        handle {
            durability { 55 }
            modifier { 0.75f }
        }
        extra {
            durability { 95 }
        }
        bow {
            speed(2f)
            range { 0.7f }
            bonusDamage { -1.5f }
        }
    }

    armor {
        armorTrait("corrosive_armor")
        core {
            durability { 13f }
            defense { 14f }
        }
        plates {
            modifier { 0.7f }
            durability { 5.5f }
            toughness { 0f }
        }
        trim {
            extraDurability { 4f }
        }
    }

}), BetweenlandsDependency
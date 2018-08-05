package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class OctineMaterial : MaterialDSL("octine", "#F38A20", {
    locale("en_7S " to "Ye Illuminating Treasure")
    forge { true }
    craft { false }
    ingots("thebetweenlands:octine_ingot")
    ores("thebetweenlands:octine_ore")
    defaultMetalParts()
    traitList(
            "HEAD" to "corrosive",
            "HEAD" to "sparking"
    )
    shininess(0.5f)
    tool {
        defaultTrait("corrosive")

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
            speed(2.5f)
            accuracy { 0.0f }
            range { 0.5f }
            string { 0.85f }
            bonusDamage { -0.5f }
        }
        shaft {
            modifier { 0.85f }
            bonusAmmo { 15 }
        }
    }
})
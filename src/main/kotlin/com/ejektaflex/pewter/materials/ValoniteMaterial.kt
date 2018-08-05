package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class ValoniteMaterial : MaterialDSL("valonite", "#845784", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:items_misc:19")
    ores("thebetweenlands:valonite_ore")
    blocks("thebetweenlands:valonite_block")
    defaultMetalParts()
    traitList(
            "HEAD" to "corrosive",
            "HEAD" to "sharp"
    )
    shininess(0.7f)
    tool {

        defaultTrait("corrosive")
        harvestLevel(2)
        head {
            durability { 775 }
            attack { 5.6f }
            speed { 5.7f }
        }
        handle {
            durability { -75 }
            modifier { 1.0f }
        }
        extra {
            durability { 160 }
        }
        bow {
            speed(4f)
            accuracy { 1.0f }
            range { 0.5f }
            string { 0.85f }
            bonusDamage { 1.5f }
        }
        shaft {
            modifier { 0.85f }
            bonusAmmo { 15 }
        }
    }
})
package com.ejektaflex.pewter.materials.betweenlands

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.BetweenlandsDependency

class ValoniteMaterial : MaterialDSL("valonite", "#845784", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:items_misc:19")
    ores("thebetweenlands:valonite_ore")
    blocks("thebetweenlands:valonite_block")
    defaultMetalParts()
    addTraits(
            //"HEAD" to "corrosive",
            "HEAD" to "sharp"
    )
    shininess(0.7f)
    tool {

        toolTrait("corrosive")

        head {
            durability { 775 }
            attack { 5.6f }
            speed { 5.7f }
            harvestLevel(2)
        }
        handle {
            durability { -75 }
            modifier { 1.0f }
        }
        extra {
            durability { 160 }
        }
        bow {
            speed(5f)
            range { 0.5f }
            bonusDamage { 1.5f }
        }
    }

    armor {
        armorTrait("corrosive_armor")
        armorTrait("rough_armor")

        core {
            durability { 12.5f }
            defense { 15.5f }
        }
        plates {
            modifier { 0.95f }
            durability { -5f }
            toughness { 0.5f }
        }
        trim {
            extraDurability { 5.5f }
        }
    }


}), BetweenlandsDependency
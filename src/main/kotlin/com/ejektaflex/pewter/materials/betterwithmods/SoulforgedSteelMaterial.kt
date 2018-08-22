package com.ejektaflex.pewter.materials.betterwithmods

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.BetterWithModsDependency

class SoulforgedSteelMaterial : MaterialDSL("soulforgedsteel", "#FF362C", {
    forge { true }
    craft { false }
    nuggets("betterwithmods:material:30")
    ingots("betterwithmods:material:14")
    blocks("betterwithmods:steel_block")
    defaultMetalParts()
    tool {
        toolTrait("heatlover")
        head {
            durability { 1124 }
            attack { 5f }
            speed { 5.8f }
            harvestLevel(3)
        }
        handle {
            durability { -55 }
            modifier { 1.2f }
        }
        extra {
            durability { 125 }
        }
        bow {
            speed(1.75f)
            range { 1.1f }
            bonusDamage { -2.5f }
        }
    }

    armor {
        armorTrait("heatlover_armor")
        core {
            durability { 19.5f }
            defense { 16f }
        }
        plates {
            modifier { 1.2f }
            durability { 1f }
            toughness { 1f }
        }
        trim {
            extraDurability { 0.5f }
        }
    }

}), BetterWithModsDependency
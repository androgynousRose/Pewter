package com.ejektaflex.pewter.materials.betterwithmods

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BetterWithModsDependency

class SoulforgedSteelMaterial : MaterialDSL("soulforgedsteel", "#464646", {
    forge { true }
    craft { false }
    nuggets("betterwithmods:material:30")
    ingots("betterwithmods:material:14")
    blocks("betterwithmods:steel_block")
    defaultMetalParts()
    shininess(0.4f)
    tool {
        toolTrait("sharp")
        head {
            durability { 824 }
            attack { 5f }
            speed { 5.8f }
            harvestLevel(3)
        }
        handle {
            durability { -55 }
            modifier { 1.2f }
        }
        extra {
            durability { 80 }
        }
        bow {
            speed(1.75f)
            range { 1.1f }
            bonusDamage { -2.5f }
        }
    }

    armor {
        armorTrait("envious_armor")
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
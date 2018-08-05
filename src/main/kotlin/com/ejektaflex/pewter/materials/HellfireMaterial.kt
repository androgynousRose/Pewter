package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class HellfireMaterial : MaterialDSL("hellfire", "#FF2E38", {
    locale("en_7S " to "Ye Fiery Treasure")
    forge { true }
    craft { false }
    ingots("betterwithmods:material:17")
    defaultMetalParts()
    tool {
        defaultTrait("heatlover")
        head {
            durability { 335 }
            attack { 4f }
            speed { 5.5f }
            harvestLevel(1)
        }
        handle {
            durability { -75 }
            modifier { 0.9f }
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

    armor {
        core {
            defense { 2f }
            durability { 2f }
        }

        plates {
            durability { 2f }
            modifier { 2f }
            toughness { 2f }
        }

        trim {
            extraDurability { 2f }
        }

    }

})
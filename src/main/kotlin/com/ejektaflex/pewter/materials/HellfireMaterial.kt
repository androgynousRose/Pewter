package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class HellfireMaterial : MaterialDSL("hellfire", "#FF2334", {
    locale("en_7S " to "Ye Fiery Treasure")
    forge { true }
    craft { false }
    ingots("betterwithmods:material:17")
    defaultMetalParts()
    tool {
        toolTrait("kindle")
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

    // little more durable little slower mining speed

    armor {
        armorTrait("kindle_armor")
        core {
            durability { 15.5f }
            defense { 13f }
        }
        plates {
            modifier { 0.75f }
            durability { 6f }
            toughness { 0f }
        }
        trim {
            extraDurability { 6f }
        }
    }

})
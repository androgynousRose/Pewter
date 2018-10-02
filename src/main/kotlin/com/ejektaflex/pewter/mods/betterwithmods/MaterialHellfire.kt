package com.ejektaflex.pewter.mods.betterwithmods

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialHellfire(matName: String) : MaterialDSL(matName, "#FF362C", {
    locale("en_7S " to "Ye Fiery Treasure")
    forge { true }
    craft { false }
    ingots("betterwithmods:material:17")
    defaultMetalParts()
    allTags("Hellfire")
    tool {
        toolTrait("heatlover")
        head {
            durability { 355 }
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
            range { 0.5f }
            bonusDamage { -0.5f }
        }
    }

    // little more durable little slower mining speed

    armor {
        armorTrait("heatlover_armor")
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
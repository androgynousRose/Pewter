package com.ejektaflex.pewter.mods.mekanism

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialOsmium : MaterialDSL("osmium", "#96CFD9", {
    forge { true }
    craft { false }
    allTags("Osmium")
    defaultMetalParts()

    tool {

        toolTrait("heavyweight")

        head {
            durability { 240 }
            attack { 4f }
            speed { 6.5f }
            harvestLevel(1)
        }
        handle {
            durability { 105 }
            modifier { 1.05f }
        }
        extra {
            durability { 35 }
        }
        bow {
            speed(6f)
            range { 1f }
            //string { 0.05f }
            bonusDamage { 6.5f }
        }
        shaft {
            modifier { 1.1f }
            bonusAmmo { 5 }
        }
    }

    armor {

        core {
            durability { 12f }
            defense { 14f }
        }
        plates {
            modifier { 0.9f }
            durability { 6f }
            toughness { 0f }
        }
        trim {
            extraDurability { 4f }
        }
    }

})
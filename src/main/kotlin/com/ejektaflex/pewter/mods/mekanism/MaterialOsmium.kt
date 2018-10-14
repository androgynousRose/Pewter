package com.ejektaflex.pewter.mods.mekanism

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialOsmium : MaterialDSL("osmium", "#a6ccdd", {
    forge { true }
    craft { false }
    allTags("Osmium")
    defaultMetalParts()

    tool {

        toolTrait("heavyweight")

        head {
            durability { 460 }
            attack { 4f }
            speed { 6.5f }
            harvestLevel(2)
        }
        handle {
            durability { 90 }
            modifier { 0.8f }
        }
        extra {
            durability { 180 }
        }
        bow {
            speed(2.6f)
            range { 0.9f }
            bonusDamage { 7f }
        }
    }

    armor {
        armorTrait("grounded_armor")
        core {
            durability { 14f }
            defense { 15.5f }
        }
        plates {
            modifier { 0.9f }
            durability { 6f }
            toughness { 1.5f }
        }
        trim {
            extraDurability { 7f }
        }
    }

})
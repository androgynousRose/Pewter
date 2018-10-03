package com.ejektaflex.pewter.mods.soot

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialAntimony(matName: String) : MaterialDSL(matName, "#89A38D", {
    forge { true }
    craft { false }
    allTags("Antimony")
    fluids("antimony")
    defaultMetalParts()
    shininess(0.35f)
    addTraits(
            //"HEAD" to "dawn"
    )
    tool {

        toolTrait("quenching")

        head {
            durability { 532 }
            attack { 4f }
            speed { 7.5f }
            harvestLevel(1)
        }
        handle {
            durability { -90 }
            modifier { 0.8f }
        }
        extra {
            durability { 120 }
        }
        bow {
            speed(2.2f)
            range { 1.1f }
            bonusDamage { 4f }
        }
    }

    armor {
        armorTrait("squelching_armor")
        core {
            durability { 17f }
            defense { 14.5f }
        }
        plates {
            modifier { 0.8f }
            durability { -4f }
            toughness { 1.75f }
        }
        trim {
            extraDurability { 8.5f }
        }
    }

})
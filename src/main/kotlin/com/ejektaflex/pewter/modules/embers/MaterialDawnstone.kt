package com.ejektaflex.pewter.modules.embers

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialDawnstone(matName: String) : MaterialDSL(matName, "#FFB648", {
    forge { true }
    craft { false }
    allSuffixes("Dawnstone")
    fluids("dawnstone")
    defaultMetalParts()
    shininess(0.55f)
    addTraits(
            "HEAD" to "dawn"
    )
    tool {

        toolTrait("simmering")

        head {
            durability { 625 }
            attack { 5.2f }
            speed { 6f }
            harvestLevel(1)
        }
        handle {
            durability { 95 }
            modifier { 0.9f }
        }
        extra {
            durability { 85 }
        }
        bow {
            speed(1.7f)
            range { 1.35f }
            bonusDamage { 6f }
        }
        shaft {
            modifier { 1.1f }
            bonusAmmo { 5 }
        }
    }

    armor {
        armorTrait("branded_armor")
        core {
            durability { 16.5f }
            defense { 15.5f }
        }
        plates {
            modifier { 1f }
            durability { 6f }
            toughness { 1.75f }
        }
        trim {
            extraDurability { 7.5f }
        }
    }

})
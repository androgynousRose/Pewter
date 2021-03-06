package com.ejektaflex.pewter.modules.botania.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialElementium(name: String) : MaterialDSL(name, "#ED339A", {
    forge { true }
    craft { false }
    blocks("botania:storage:2")
    allSuffixes("ElvenElementium")
    defaultMetalParts()
    shininess(0.6f)
    addTraits(
            //"HEAD" to "essentia"
    )
    tool {

        toolTrait("manainfused")

        head {
            durability { 480 }
            attack { 4.5f }
            speed { 6.25f }
            harvestLevel(2)
        }
        handle {
            durability { 30 }
            modifier { 1.05f }
        }
        extra {
            durability { 125 }
        }
        bow {
            speed(1.6f)
            range { 1f }
            bonusDamage { 6f }
        }
    }

    armor {
        armorTrait("manainfused_armor")
        core {
            durability { 15.5f }
            defense { 14.5f }
        }
        plates {
            modifier { 1.3f }
            durability { -6f }
            toughness { 0.5f }
        }
        trim {
            extraDurability { 5.5f }
        }
    }

})
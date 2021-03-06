package com.ejektaflex.pewter.modules.botania.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialManasteel(name: String) : MaterialDSL(name, "#005EE0", {
    forge { true }
    craft { false }
    allSuffixes("Manasteel")
    blocks("botania:storage")
    defaultMetalParts()
    shininess(0.8f)
    addTraits(
            //"HEAD" to "essentia"
    )
    tool {

        toolTrait("manainfused")

        head {
            durability { 276 }
            attack { 4.2f }
            speed { 6f }
            harvestLevel(2)
        }
        handle {
            durability { 100 }
            modifier { 0.85f }
        }
        extra {
            durability { 75 }
        }
        bow {
            speed(2.2f)
            range { 1.2f }
            bonusDamage { 4f }
        }
    }

    armor {
        armorTrait("manainfused_armor")
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
            extraDurability { 3.5f }
        }
    }

})
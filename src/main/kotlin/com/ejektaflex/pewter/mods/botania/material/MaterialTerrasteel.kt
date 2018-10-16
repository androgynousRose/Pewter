package com.ejektaflex.pewter.mods.botania.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialTerrasteel(name: String) : MaterialDSL(name, "#5CFF12", {
    forge { true }
    craft { false }
    blocks("botania:storage:1")
    allSuffixes("Terrasteel")
    defaultMetalParts()
    brightness(0.1f)
    shininess(0.35f)
    addTraits(
            "CORE" to "terra_armor"
    )
    tool {

        toolTrait("manainfused")

        head {
            durability { 1504 }
            attack { 5.6f }
            speed { 6f }
            harvestLevel(4)
        }
        handle {
            durability { 0 }
            modifier { 0.9f }
        }
        extra {
            durability { 85 }
        }
        bow {
            speed(1.85f)
            range { 1.1f }
            bonusDamage { 8f }
        }
    }

    armor {
        armorTrait("manainfused_armor")
        core {
            durability { 20.2f }
            defense { 18f }
        }
        plates {
            modifier { 0.9f }
            durability { 5f }
            toughness { 1.5f }
        }
        trim {
            extraDurability { 13f }
        }
    }

})
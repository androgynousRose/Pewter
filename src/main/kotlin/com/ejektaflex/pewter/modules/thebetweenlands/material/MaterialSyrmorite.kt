package com.ejektaflex.pewter.modules.thebetweenlands.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialSyrmorite(name: String) : MaterialDSL(name, "#1E336C", {
    forge { true }
    craft { false }
    allSuffixes("Syrmorite")
    defaultMetalParts()
    addTraits(
            //"HEAD" to "corrosive",
            "HEAD" to "gritty"
    )
    shininess(0.25f)
    tool {

        toolTrait("corrosive")

        head {
            durability { 620 }
            attack { 5.1f }
            speed { 5.2f }
            harvestLevel(2)
        }
        handle {
            durability { -45 }
            modifier { 1.15f }
        }
        extra {
            durability { 125 }
        }
        bow {
            speed(2.5f)
            range { 0.5f }
            bonusDamage { 1.5f }
        }
    }

    armor {
        armorTrait("corrosive_armor")
        armorTrait("splash_armor")

        core {
            durability { 16.5f }
            defense { 16f }
        }
        plates {
            modifier { 0.9f }
            durability { 6f }
            toughness { 05f }
        }
        trim {
            extraDurability { 8.5f }
        }
    }

})
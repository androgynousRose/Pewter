package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL

class TerrasteelMaterial : MaterialDSL("terrasteel", "#5CFF12", {
    forge { true }
    craft { false }
    blocks("botania:storage:1")
    ingots("botania:manaresource:4")
    nuggets("botania:manaresource:18")
    defaultMetalParts()
    brightness(0.1f)
    shininess(0.35f)
    addTraits(
            "HEAD" to "essentia"
    )
    tool {

        toolTrait("manainfused")

        head {
            durability { 1504 }
            attack { 5.1f }
            speed { 6f }
            harvestLevel(2)
        }
        handle {
            durability { 0 }
            modifier { 0.9f }
        }
        extra {
            durability { 85 }
        }
        bow {
            speed(2.5f)
            range { 1.75f }
            string { 0.05f }
            bonusDamage { 6.5f }
        }
        shaft {
            modifier { 1.1f }
            bonusAmmo { 5 }
        }
    }

    armor {
        armorTrait("visbarrier_armor")
        core {
            durability { 12f }
            defense { 18f }
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
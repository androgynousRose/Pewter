package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL

class ElementiumMaterial : MaterialDSL("elementium", "#ED339A", {
    forge { true }
    craft { false }
    blocks("botania:storage:2")
    ingots("botania:manaresource:7")
    nuggets("botania:manaresource:19")
    defaultMetalParts()
    shininess(0.6f)
    addTraits(
            "HEAD" to "essentia"
    )
    tool {

        toolTrait("manainfused")

        head {
            durability { 480 }
            attack { 4.5f }
            speed { 6.25f }
            harvestLevel(1)
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
            bonusDamage { 3.5f }
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
            durability { -2f }
            toughness { 0.5f }
        }
        trim {
            extraDurability { 5.5f }
        }
    }

})
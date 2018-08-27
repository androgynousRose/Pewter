package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BotaniaDependency

class TerrasteelMaterial : MaterialDSL("terrasteel", "#5CFF12", {
    forge { true }
    craft { false }
    blocks("botania:storage:1")
    allTags("Terrasteel")
    defaultMetalParts()
    brightness(0.1f)
    shininess(0.35f)
    addTraits(
            //"HEAD" to "essentia"
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
            modifier { 0.95f }
            durability { 5f }
            toughness { 1f }
        }
        trim {
            extraDurability { 3f }
        }
    }

}), BotaniaDependency
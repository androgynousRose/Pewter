package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BotaniaDependency

class ManasteelMaterial : MaterialDSL("manasteel", "#005EE0", {
    forge { true }
    craft { false }
    blocks("botania:storage")
    ingotTags("ingotManasteel")
    nuggetTags("nuggetManasteel")
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
            bonusDamage { 6.5f }
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

}), BotaniaDependency
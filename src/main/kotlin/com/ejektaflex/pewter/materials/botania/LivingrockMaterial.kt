package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BotaniaDependency

class LivingrockMaterial : MaterialDSL("livingrock", "#E5DFCF", {
    forge { false }
    craft { true }
    ingots("botania:livingrock")
    defaultMetalParts()
    shininess(0f)
    brightness(0.15f)
    addTraits(
            "HEAD" to "cheapskate",
            "HANDLE" to "cheap",
            "EXTRA" to "cheap",
            "BOW" to "cheap"
    )
    tool {
        head {
            durability { 150 }
            attack { 3f }
            speed { 4.5f }
            harvestLevel(1)
        }
        handle {
            durability { -25 }
            modifier { 0.5f }
        }
        extra {
            durability { 20 }
        }
        bow {
            speed(4.5f)
            range { 0.5f }
            bonusDamage { -1f }
        }
    }

    armor {
        armorTrait("adapting_armor")
        core {
            durability { 9.1f }
            defense { 5.2f }
        }
        plates {
            modifier { 0.5f }
            durability { -1f }
            toughness { 0f }
        }
        trim {
            extraDurability { 1f }
        }
    }


}), BotaniaDependency
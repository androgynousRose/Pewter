package com.ejektaflex.pewter.materials.example

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.ExampleDependency

class ExampleMaterial : MaterialDSL("examplematerial", "#666688", {
    locale("en_us" to "Test Material.", "en_pt" to "Ye Olde Material")
    forge { true }
    craft { false }
    ingots("minecraft:apple")
    defaultMetalParts()
    addTraits(
            "EXTRA" to "dense"
    )
    tool {
        toolTrait("brilliance")
        head {
            durability { 100 }
            attack { 5f }
            speed { 1f }
        }
        handle {
            durability { 50 }
            modifier { 1f }
        }
        extra {
            durability { 25 }
        }
        bow {
            speed(2.5f)
            accuracy { 0.5f }
            range { 1f }
            string { 1.1f }
            bonusDamage { 5f }
        }
        shaft {
            modifier { 1.1f }
            bonusAmmo { 5 }
        }
    }
}), ExampleDependency
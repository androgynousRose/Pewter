package com.ejektaflex.pewter.modules.unused

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialExample : MaterialDSL("examplematerial", "#666688", {
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

    armor {
        armorTrait("heatlover_armor")
        core {
            durability { 15.5f }
            defense { 13f }
        }
        plates {
            modifier { 0.75f }
            durability { 6f }
            toughness { 0f }
        }
        trim {
            extraDurability { 6f }
        }
    }

})
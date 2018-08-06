package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class AlchemicalBrassMaterial : MaterialDSL("alchemicalbrass", "#D2983A", {
    forge { true }
    craft { false }
    ingots("thaumcraft:ingot:2")
    nuggets("thaumcraft:nugget:8")
    blocks("thaumcraft:metal_brass")
    noMeltRecipes()
    fluid("brass")
    defaultMetalParts()
    addTraits(
            "HEAD" to "attuned",
            "CORE" to "shielding_armor",
            "PLATES" to "dense_armor",
            "TRIM" to "dense_armor"
    )
    tool {

        toolTrait("heavyweight")

        head {
            durability { 240 }
            attack { 4f }
            speed { 6.5f }
            harvestLevel(1)
        }
        handle {
            durability { 105 }
            modifier { 1.05f }
        }
        extra {
            durability { 35 }
        }
        bow {
            speed(2.5f)
            accuracy { 0.85f }
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
            extraDurability { 4f }
        }
    }

})
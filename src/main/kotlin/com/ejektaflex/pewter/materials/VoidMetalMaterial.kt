package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class VoidMetalMaterial : MaterialDSL("voidmetal", "#2A114A", {
    forge { true }
    craft { false }
    ingots("thaumcraft:ingot:1")
    blocks("thaumcraft:metal_void")
    nuggets("thaumcraft:nugget:7")
    defaultMetalParts()
    addTraits(
            //"HEAD" to "warping",
            "HEAD" to "sapping"
    )
    tool {

        toolTrait("warping")

        head {
            durability { 740 }
            attack { 5.3f }
            speed { 5.8f }
            harvestLevel(3)
        }
        handle {
            durability { -55 }
            modifier { 1.15f }
        }
        extra {
            durability { 200 }
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
        armorTrait("maniacal_armor")
        core {
            durability { 16.5f }
            defense { 17.5f }
        }
        plates {
            modifier { 1.05f }
            durability { -3.5f }
            toughness { 1f }
        }
        trim {
            extraDurability { 6f }
        }
    }


})
package com.ejektaflex.pewter.integrations

import com.ejektaflex.pewter.dsl.MaterialDSL

class VoidMetalMaterial : MaterialDSL("voidmetal", "#2A114A", {
    locale("en_US" to "Void Metal")
    forge { true }
    craft { false }
    ingots("thaumcraft:ingot:1")
    blocks("thaumcraft:metal_void")
    nuggets("thaumcraft:nugget:7")
    defaultMetalParts()
    defaultTrait("warping")
    traitList(
            "HEAD" to "warping",
            "HEAD" to "sapping"
    )
    harvestLevel(3)
    head {
        durability { 840 }
        attack { 6 }
        speed { 5.0f }
    }
    handle {
        durability { -15 }
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
})
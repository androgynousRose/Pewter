package com.ejektaflex.pewter.integrations

import com.ejektaflex.pewter.dsl.MaterialDSL

class VoidMetalMaterial : MaterialDSL("voidmetal", "#220E3D", {
    locale("en_US" to "Void Metal")
    forge { true }
    craft { false }
    ingots("thaumcraft:ingot:1")
    blocks("thaumcraft:metal_void")
    nuggets("thaumcraft:nugget:7")
    defaultMetalParts()
    defaultTrait("warping")
    harvestLevel(3)
    head {
        durability { 840 }
        attack { 4 }
        speed { 7.0f }
    }
    handle {
        durability { -15 }
        modifier { 1.15f }
    }
    extra {
        durability { 35 }
    }
    bow {
        speed(0.5f)
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
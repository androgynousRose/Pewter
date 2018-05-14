package com.ejektaflex.pewter.integrations

import com.ejektaflex.pewter.dsl.MaterialDSL

class ExampleMaterial : MaterialDSL("examplematerial", "#666688", {
    locale("en_US" to "Test Material.")
    forge { true }
    craft { false }
    ingots("minecraft:apple")
    defaultMetalParts()
    defaultTrait("brilliance")
    traitList(
            "EXTRA" to "dense"
    )
    head {
        durability { 100 }
        attack { 5 }
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
})
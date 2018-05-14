package com.ejektaflex.pewter.integrations

import com.ejektaflex.pewter.dsl.MaterialDSL

class StarmetalMaterial : MaterialDSL("starmetal", "#222288", {
    locale("en_US" to "Starmetal")
    forge { true }
    craft { false }
    ingots("astralsorcery:itemcraftingcomponent:1")
    defaultMetalParts()
    defaultTrait("brilliance")
    traitMap(
            "EXTRA" to "dense"
    )
    harvestLevel(1)
    head {
        durability { 275 }
        attack { 5 }
        speed { 6.5f }
    }
    handle {
        durability { 85 }
        modifier { 0.75f }
    }
    extra {
        durability { 35 }
    }
    bow {
        speed(0.5f)
        accuracy { 1.0f }
        range { 1.6f }
        string { 0.2f }
        bonusDamage { 6.5f }
    }
    shaft {
        modifier { 1.2f }
        bonusAmmo { 5 }
    }
})
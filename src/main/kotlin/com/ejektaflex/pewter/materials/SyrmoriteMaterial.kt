package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class SyrmoriteMaterial : MaterialDSL("syrmorite", "#1E336C", {
    forge { true }
    craft { false }
    ingots("thebetweenlands:items_misc:11")
    ores("thebetweenlands:syrmorite_ore")
    blocks("thebetweenlands:syrmorite_block")
    defaultMetalParts()
    defaultTrait("corrosive")
    traitList(
            "HEAD" to "corrosive",
            "HEAD" to "gritty"
    )
    harvestLevel(1)
    shininess(0.25f)
    head {
        durability { 620 }
        attack { 5.3f }
        speed { 5.2f }
    }
    handle {
        durability { 25 }
        modifier { 1.15f }
    }
    extra {
        durability { 125 }
    }
    bow {
        speed(2.5f)
        accuracy { 1.0f }
        range { 0.5f }
        string { 0.85f }
        bonusDamage { 1.5f }
    }
    shaft {
        modifier { 0.85f }
        bonusAmmo { 15 }
    }
})
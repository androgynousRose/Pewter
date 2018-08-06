package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL

class SyrmoriteMaterial : MaterialDSL("syrmorite", "#1E336C", {
    forge { true }
    craft { false }
    ingots("thebetweenlands:items_misc:11")
    ores("thebetweenlands:syrmorite_ore")
    blocks("thebetweenlands:syrmorite_block")
    defaultMetalParts()
    addTraits(
            //"HEAD" to "corrosive",
            "HEAD" to "gritty"
    )
    shininess(0.25f)
    tool {

        toolTrait("corrosive")

        head {
            durability { 620 }
            attack { 5.1f }
            speed { 5.2f }
            harvestLevel(2)
        }
        handle {
            durability { -45 }
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
    }

    armor {
        armorTrait("corrosive_armor")
        armorTrait("splash_armor")

        core {
            durability { 16.5f }
            defense { 16f }
        }
        plates {
            modifier { 0.9f }
            durability { 6f }
            toughness { 05f }
        }
        trim {
            extraDurability { 8.5f }
        }
    }


})
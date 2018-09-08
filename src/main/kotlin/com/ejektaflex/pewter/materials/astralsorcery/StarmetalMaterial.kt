package com.ejektaflex.pewter.materials.astralsorcery

import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.AstralSorceryDependency

class StarmetalMaterial : MaterialDSL("starmetal", "#222288", {
    forge { true }
    craft { false }
    ingots("astralsorcery:itemcraftingcomponent:1")
    //fluids("astral_starmetal")
    defaultMetalParts()
    addTraits(
            "HEAD" to "dense"
    )
    shininess(0.6f)
    tool {
        toolTrait("brilliance")
        head {
            durability { 275 }
            attack { 4.2f }
            speed { 5.7f }
            harvestLevel(1)
        }
        handle {
            durability { 95 }
            modifier { 0.8f }
        }
        extra {
            durability { 65 }
        }
        bow {
            speed(2.1f)
            range { 1.1f }
            bonusDamage { 4.5f }
        }
    }

    // higher attack lower speed
    armor {
        armorTrait("featherweight_armor")
        core {
            durability { 14f }
            defense { 10f }
        }
        plates {
            modifier { 0.8f }
            durability { 2.5f }
            toughness { 0f }
        }
        trim {
            extraDurability { 7.5f }
        }
    }


}), AstralSorceryDependency
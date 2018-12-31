package com.ejektaflex.pewter.modules.betterwithmods

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialSoulforgedSteel(matName: String) : MaterialDSL(matName, "#464646", {
    forge { true }
    craft { false }
    ingotTags("ingotSoulforgedSteel")
    nuggetTags("nuggetSoulforgedSteel")
    defaultMetalParts()
    shininess(0.6f)
    tool {
        toolTrait("sharp")
        head {
            durability { 824 }
            attack { 5f }
            speed { 5.8f }
            harvestLevel(3)
        }
        handle {
            durability { -55 }
            modifier { 1.2f }
        }
        extra {
            durability { 80 }
        }
        bow {
            speed(1.75f)
            range { 1.4f }
            bonusDamage { 7f }
        }
    }

    armor {
        armorTrait("envious_armor")
        core {
            durability { 18.5f }
            defense { 16f }
        }
        plates {
            modifier { 1.2f }
            durability { 2f }
            toughness { 1f }
        }
        trim {
            extraDurability { 1.5f }
        }
    }

})
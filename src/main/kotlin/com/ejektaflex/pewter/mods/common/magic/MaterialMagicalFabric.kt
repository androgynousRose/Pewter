package com.ejektaflex.pewter.mods.common.magic

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialMagicalFabric(matName: String) : MaterialDSL(matName, "#66d1dd", {
    forge { false }
    craft { true }
    ingots("botania:manaresource:22")
    ingots("thaumcraft:fabric")
    armorParts()
    brightness(0.02f)

    armor {
        armorTrait("ashwoven_armor")
        core {
            durability { 10.5f }
            defense { 4f }
        }
        plates {
            modifier { 0.65f }
            durability { 2.5f }
            toughness { 0f }
        }
        trim {
            extraDurability { 5f }
        }
    }

})
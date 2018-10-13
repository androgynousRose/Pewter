package com.ejektaflex.pewter.mods.common.magic

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialMagicalFabric(matName: String) : MaterialDSL(matName, "#66b9dd", {
    forge { false }
    craft { true }
    ingots("botania:manaresource:22")
    ingots("thaumcraft:fabric")
    armorParts()
    brightness(0.02f)

    armor {
        armorTrait("magical_armor")
        core {
            durability { 9.25f }
            defense { 4.2f }
        }
        plates {
            modifier { 0.75f }
            durability { 1.5f }
            toughness { 0f }
        }
        trim {
            extraDurability { 3f }
        }
    }
})
package com.ejektaflex.pewter.modules.embers

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialAshenFabric(matName: String) : MaterialDSL(matName, "#303030", {
    forge { false }
    craft { true }
    ingots("embers:ashen_cloth")
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
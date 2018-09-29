package com.ejektaflex.pewter.mods.embers

import com.ejektaflex.pewter.api.core.materials.MaterialDSL

class MaterialAshenFabric : MaterialDSL("ashenfabric", "#303030", {
    forge { false }
    craft { true }
    //allTags("Dawnstone")
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
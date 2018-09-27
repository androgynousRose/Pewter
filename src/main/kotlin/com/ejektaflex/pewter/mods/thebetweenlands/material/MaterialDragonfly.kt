package com.ejektaflex.pewter.mods.thebetweenlands.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData

class MaterialDragonfly : MaterialDSL("dragonflywing", "#6BBEBF", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:items_misc:3")
    parts(MaterialData.MatPart.FLETCHING)
    addTraits(
            "FLETCHING" to "buzzing"
            )
    tool {
        bow {
            fletchingMod(1.35f)
            accuracy { 0.85f }
        }
    }
})
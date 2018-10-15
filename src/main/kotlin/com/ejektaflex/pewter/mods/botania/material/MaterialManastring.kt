package com.ejektaflex.pewter.mods.botania.material

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData.MatPart

class MaterialManastring(name: String) : MaterialDSL(name, "#6BBEBF", {
    forge { false }
    craft { true }
    allTags("manaString")
    ingots("botania:manaresource:16")
    parts(MatPart.BOWSTRING)
    //toolTrait("heatlover")
    tool {
        toolTrait("manainfused")
        bow {
            string { 0.85f }
        }
    }
})
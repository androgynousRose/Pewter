package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BotaniaDependency
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData.MatPart

class ManastringMaterial : MaterialDSL("manastring", "#6BBEBF", {
    forge { false }
    craft { true }
    ingotTags("manaString")
    ingots("botania:manaresource:16")
    parts(MatPart.BOWSTRING)
    //toolTrait("heatlover")
    tool {
        toolTrait("manainfused")
        bow {
            string { 0.85f }
        }
    }
}), BotaniaDependency
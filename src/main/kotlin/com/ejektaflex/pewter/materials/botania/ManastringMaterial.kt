package com.ejektaflex.pewter.materials.botania

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.materials.BotaniaDependency
import com.ejektaflex.pewter.logic.stats.MaterialData.MatPart

class ManastringMaterial : MaterialDSL("manastring", "#6BBEBF", {
    forge { false }
    craft { true }
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
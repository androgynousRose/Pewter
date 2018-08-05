package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.stats.MaterialStats.MatPart

class ManastringMaterial : MaterialDSL("manastring", "#6BBEBF", {
    forge { false }
    craft { true }
    ingots("botania:manaresource:16")
    parts(MatPart.BOWSTRING)
    //defaultTrait("heatlover")
    tool {
        bow {
            string { 0.85f }
        }
    }
})
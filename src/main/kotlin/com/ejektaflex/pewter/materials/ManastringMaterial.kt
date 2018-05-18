package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.MaterialStats.MatPart

class ManastringMaterial : MaterialDSL("manastring", "#6BBEBF", {
    forge { false }
    craft { true }
    ingots("botania:manaresource:16")
    parts(MatPart.BOWSTRING)
    //defaultTrait("heatlover")
    bow {
        string { 0.85f }
    }
})
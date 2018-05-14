package com.ejektaflex.pewter.integrations

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.MaterialStats.MatPart

class ManastringMaterial : MaterialDSL("manastring", "#6BBEBF", {
    locale("en_US" to "Manastring")
    forge { false }
    craft { true }
    ingots("botania:manaresource:16")
    parts(MatPart.BOWSTRING)
    //defaultTrait("heatlover")
    bow {
        speed(0.5f)
        string { 0.85f }
        bonusDamage { -0.5f }
    }
})
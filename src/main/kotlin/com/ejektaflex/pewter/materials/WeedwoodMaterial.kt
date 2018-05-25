package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.MaterialStats

class WeedwoodMaterial : MaterialDSL("weedwood", "#665E31", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:weedwood_planks")
    defaultMetalParts()
    parts(MaterialStats.MatPart.SHAFT)
    defaultTrait("corrosive")
    traitList(
            "HEAD" to "corrosive",
            "HEAD" to "ecological",
            "HANDLE" to "corrosive",
            "HANDLE" to "ecological",
            "EXTRA" to "corrosive",
            "EXTRA" to "ecological",
            "BOW" to "corrosive",
            "BOW" to "ecological",
            "SHAFT" to "corrosive",
            "SHAFT" to "ecological",
            "PROJECTILE" to "corrosive",
            "PROJECTILE" to "ecological"
    )
    harvestLevel(0)
    shininess(0.15f)
    head {
        durability { 75 }
        attack { 2.2f }
        speed { 2.4f }
    }
    handle {
        durability { 40 }
        modifier { 1.1f }
    }
    extra {
        durability { 25 }
    }
    bow {
        speed(0.95f)
        accuracy { 0.9f }
        range { 0.9f }
        string { 0.85f }
        bonusDamage { -0.5f }
    }
    shaft {
        modifier { 0.9f }
        bonusAmmo { 15 }
    }
})
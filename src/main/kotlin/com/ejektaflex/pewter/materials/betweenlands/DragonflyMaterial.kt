package com.ejektaflex.pewter.materials.betweenlands

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.lib.dependencies.BetweenlandsDependency
import com.ejektaflex.pewter.logic.stats.MaterialData

class DragonflyMaterial : MaterialDSL("dragonflywing", "#6BBEBF", {
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
}), BetweenlandsDependency
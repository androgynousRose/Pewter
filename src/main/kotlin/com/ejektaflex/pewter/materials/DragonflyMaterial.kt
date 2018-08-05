package com.ejektaflex.pewter.materials

import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.MaterialStats

class DragonflyMaterial : MaterialDSL("dragonflywing", "#6BBEBF", {
    forge { false }
    craft { true }
    ingots("thebetweenlands:items_misc:3")
    parts(MaterialStats.MatPart.FLETCHING)
    tool {
        bow {
            fletchingMod(1.1f)
            accuracy { 0.85f }
        }
    }
})
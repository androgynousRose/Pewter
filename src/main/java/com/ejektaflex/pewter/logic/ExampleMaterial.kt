package com.ejektaflex.pewter.logic

import com.ejektaflex.pewter.dsl.MaterialDSL

class ExampleMaterial : MaterialDSL("examplematerial", "#666688", {
    locale("en_US" to "Test Material.")
    forge { true }
    craft { false }
    ingots("minecraft:apple")
    //icon("minecraft:apple")
    head {
        durability { 100 }
        attack { 5 }
        speed { 1f }
    }
    handle {
        durability { 50 }
        mult { 1f }
    }
    extra {
        durability { 25 }
    }
    bow {
        accuracy { 0.5f }
        range { 1f }
        string { 1.1f }
        bonusDamage { 5f }
    }
    shaft {
        modifier { 1.1f }
        bonusAmmo { 5 }
    }
})
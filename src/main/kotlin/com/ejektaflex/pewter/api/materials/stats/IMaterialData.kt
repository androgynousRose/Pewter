package com.ejektaflex.pewter.api.materials.stats

interface IMaterialData {

    var tool: ToolStats
    
    var smelting: MutableMap<String, MutableList<String>>

    var armor: ArmorStats?
    
}
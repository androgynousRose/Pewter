package com.ejektaflex.pewter.logic.stats

interface IMaterialData {

    var tool: ToolStats
    
    var smelting: MutableMap<String, MutableList<String>>

    var armor: ArmorStats?
    
}
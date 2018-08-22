package com.ejektaflex.pewter.logic.stats

import slimeknights.tconstruct.library.materials.Material

class SmeltingStats {

    val ingot = mutableListOf<String>()
    val block = mutableListOf<String>()
    val nugget = mutableListOf<String>()
    val ore = mutableListOf<String>()

    operator fun get(type: SmeltingType): MutableList<String> {
        return type.getter(this)
    }

    fun allItems(): List<String> {
        return SmeltingType.values().map { it.getter(this) }.flatten()
    }

    enum class SmeltingType(val getter: SmeltingStats.() -> MutableList<String>, val amount: Int) {
        INGOT({ ingot }, Material.VALUE_Ingot),
        BLOCK({ block }, Material.VALUE_Nugget),
        NUGGET({ nugget }, Material.VALUE_Block),
        ORE({ ore }, Material.VALUE_Ore())
    }

}
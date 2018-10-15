package com.ejektaflex.pewter.api.core.materials.stats

import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.smeltery.TinkerSmeltery

class SmeltingStats {

    val ingot = mutableListOf<String>()
    val block = mutableListOf<String>()
    val nugget = mutableListOf<String>()
    val ore = mutableListOf<String>()
    val dust = mutableListOf<String>()

    operator fun get(type: SmeltingType): MutableList<String> {
        return type.getter(this)
    }

    enum class SmeltingType(val getter: SmeltingStats.() -> MutableList<String>, val amount: Int) {
        INGOT({ ingot }, Material.VALUE_Ingot),
        BLOCK({ block }, Material.VALUE_Block),
        NUGGET({ nugget }, Material.VALUE_Nugget),
        ORE({ ore }, Material.VALUE_Ore())
    }

}
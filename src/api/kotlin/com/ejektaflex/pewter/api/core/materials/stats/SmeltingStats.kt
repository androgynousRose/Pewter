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
        return type.of(this)
    }

    override fun toString(): String {
        return "Ingots: $ingot" +
                "Blocks: $block" +
                "Nugget: $nugget" +
                "Ores:   $ore" +
                "Dusts:  $dust"
    }

    enum class SmeltingType(val of: SmeltingStats.() -> MutableList<String>, val amount: Int, val getCast: () -> ItemStack?) {
        INGOT({ ingot }, Material.VALUE_Ingot, { TinkerSmeltery.castIngot }),
        BLOCK({ block }, Material.VALUE_Block, { null }),
        DUST({ dust }, Material.VALUE_Ore(), { null }),
        NUGGET({ nugget }, Material.VALUE_Nugget, { TinkerSmeltery.castNugget }),
        ORE({ ore }, Material.VALUE_Ore(), { null })
    }

}
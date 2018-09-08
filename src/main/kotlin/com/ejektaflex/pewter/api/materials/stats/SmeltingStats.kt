package com.ejektaflex.pewter.api.materials.stats

import com.ejektaflex.pewter.ext.toItemStack
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary
import slimeknights.tconstruct.library.materials.Material

class SmeltingStats {

    val ingot = mutableListOf<String>()
    val block = mutableListOf<String>()
    val nugget = mutableListOf<String>()
    val ore = mutableListOf<String>()

    operator fun get(type: SmeltingType): MutableList<String> {
        return type.getter(this)
    }

    private fun names(): List<String> {
        return SmeltingType.values().map { it.getter(this) }.flatten()
    }

    fun representativeItem(isOreDict: Boolean = false): ItemStack? {
        return if (!isOreDict) {
            names().firstOrNull()?.toItemStack
        } else {
            val firstTag = names().firstOrNull()
            firstTag?.let {
                OreDictionary.getOres(firstTag).firstOrNull()
            }
        }
    }

    enum class SmeltingType(val getter: SmeltingStats.() -> MutableList<String>, val amount: Int) {
        INGOT({ ingot }, Material.VALUE_Ingot),
        BLOCK({ block }, Material.VALUE_Block),
        NUGGET({ nugget }, Material.VALUE_Nugget),
        ORE({ ore }, Material.VALUE_Ore())
    }

}
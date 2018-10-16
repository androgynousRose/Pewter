package com.ejektaflex.pewter.logic.crafting

import com.ejektaflex.pewter.api.core.materials.stats.SmeltingStats
import com.ejektaflex.pewter.logic.MaterialRegistrar
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary
import slimeknights.mantle.util.RecipeMatch
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.smeltery.MeltingRecipe

class TagSmelteryHandler(private val reg: MaterialRegistrar) : ISmelteryHandler {

    override val statBase: () -> SmeltingStats = { reg.data.smeltingTags }

    override fun associate(input: String, smeltingType: SmeltingStats.SmeltingType) {
        if (reg.fluid != null && reg.data.createMeltingRecipes) {
            reg.tinkMaterial.addItem(input, 1, smeltingType.amount)
        }
    }

    override fun integrate(input: String, smeltingType: SmeltingStats.SmeltingType) {
        if (reg.fluid != null && reg.data.createMeltingRecipes) {
            val meltingRecipe = MeltingRecipe(
                    RecipeMatch.of(input, smeltingType.amount),
                    reg.fluid,
                    reg.data.meltingTemperature
            )
            TinkerRegistry.registerMelting(meltingRecipe)

            OreDictionary.getOres(input).firstOrNull()?.let { outputItem ->
                registerCasting(outputItem, reg.fluid!!, statBase(), smeltingType)
            }
        }
    }

    override fun representativeItem(): ItemStack? {
        val smeltNames = SmeltingStats.SmeltingType.values().map { it.of(statBase()) }.flatten()
        val firstTag = smeltNames.firstOrNull()
        firstTag?.let {
            return OreDictionary.getOres(firstTag).firstOrNull()
        }
        return null
    }

}
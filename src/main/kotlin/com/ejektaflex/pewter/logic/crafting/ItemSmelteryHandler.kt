package com.ejektaflex.pewter.logic.crafting

import com.ejektaflex.pewter.api.core.materials.stats.SmeltingStats
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.PewterLogger
import com.ejektaflex.pewter.logic.MaterialRegistrar
import net.minecraft.item.ItemStack
import slimeknights.mantle.util.RecipeMatch
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.smeltery.MeltingRecipe

class ItemSmelteryHandler(private val reg: MaterialRegistrar) : ISmelteryHandler {

    override val statBase: () -> SmeltingStats = { reg.data.smeltingItems }

    override fun associate(input: String, smeltingType: SmeltingStats.SmeltingType) {
        input.toItemStack?.let {
            reg.tinkMaterial.addItem(it, 1, smeltingType.amount)
        }
    }

    override fun integrate(stackName: String, smeltingType: SmeltingStats.SmeltingType) {
        val itemStack = stackName.toItemStack
        // If that item exists, configure it
        if (itemStack != null) {
            if (reg.fluid != null && reg.data.createMeltingRecipes) {
                val meltingRecipe = MeltingRecipe(
                        RecipeMatch.of(itemStack, smeltingType.amount),
                        reg.fluid,
                        reg.data.meltingTemperature
                )
                TinkerRegistry.registerMelting(meltingRecipe)
                registerCasting(itemStack, reg.fluid!!, statBase(), smeltingType)

            }
        } else {
            PewterLogger.warn("Could not associate $stackName with material named '${reg.data.name}'! Reason is because the item doesn't exist.")
        }
    }




    override fun representativeItem(): ItemStack? {
        val smeltNames = SmeltingStats.SmeltingType.values().map { it.of(statBase()) }.flatten()
        return smeltNames.firstOrNull()?.toItemStack
    }

}
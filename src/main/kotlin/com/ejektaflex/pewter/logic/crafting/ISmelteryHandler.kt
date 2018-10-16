package com.ejektaflex.pewter.logic.crafting

import com.ejektaflex.pewter.api.core.materials.stats.SmeltingStats
import com.ejektaflex.pewter.lib.PewterLogger
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.Fluid
import slimeknights.mantle.util.RecipeMatch
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.smeltery.CastingRecipe

interface ISmelteryHandler {


    val statBase: () -> SmeltingStats

    fun associateAll() {
        handle { input, smeltType -> associate(input, smeltType) }
    }

    fun integrateAll() {
        handle { input, smeltType -> integrate(input, smeltType) }
    }

    fun handle(func: (input: String, smeltType: SmeltingStats.SmeltingType) -> Unit) {
        for (smeltingType in SmeltingStats.SmeltingType.values() ) {
            statBase()[smeltingType].forEach { itemString ->
                func(itemString, smeltingType)
            }
        }
    }

    fun associate(input: String, smeltingType: SmeltingStats.SmeltingType)

    fun integrate(stackName: String, smeltingType: SmeltingStats.SmeltingType)

    fun representativeItem(): ItemStack?

    fun registerCasting(stack: ItemStack, fluid: Fluid, smeltingStats: SmeltingStats, smeltingType: SmeltingStats.SmeltingType) {
        if (smeltingType == SmeltingStats.SmeltingType.BLOCK) {
            TinkerRegistry.registerBasinCasting(
                    CastingRecipe(
                            stack,
                            fluid,
                            smeltingType.amount,
                            CastingRecipe.calcCooldownTime(fluid, smeltingType.amount) / 3
                    )
            )
        } else {
            smeltingType.getCast()?.let {
                TinkerRegistry.registerTableCasting(stack, it, fluid, smeltingType.amount)
            }
        }
    }

}
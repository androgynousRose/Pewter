package com.ejektaflex.pewter.lib.modifiers

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.lib.mixins.ConfigurableModifier
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.modifiers.ModifierTrait

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ModifierTrait(identifier, color, maxLevel, countPerLevel), ConfigurableModifier {
    init {
        Pewter.LOGGER.info("Creating modifier: $name")
        MinecraftForge.EVENT_BUS.register(this)
    }

    // Apparently getItems() crashes if there are no registered items
    fun getItemsSafe(): List<List<ItemStack>>? {
        return try {
            getItems()
        } catch (e: Exception) {
            null
        }
    }
}
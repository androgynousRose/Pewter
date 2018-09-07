package com.ejektaflex.pewter.lib.modifiers

import c4.conarm.lib.modifiers.ArmorModifier
import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.lib.mixins.ConfigurableModifier
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge

// Does not actually leak
@Suppress("LeakingThis")
abstract class PewterArmorModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ArmorModifier(identifier, color), ConfigurableModifier {
    init {
        Pewter.LOGGER.info("Creating armor modifier: $name (id: $identifier)")
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

    fun safeAdd(stack: ItemStack?) {
        stack?.let { RecipeMatchHolder.addItem(this, it, 1, 1) }
    }

}

package com.ejektaflex.pewter.api.core.modifiers

import c4.conarm.lib.modifiers.ArmorModifierTrait
import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge

/**
 * Extend this if you want to create a new armor modifier.
 */
@Suppress("LeakingThis")
abstract class PewterArmorModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ArmorModifierTrait(identifier, color, maxLevel, countPerLevel), IPewterArmorModifier {
    init {
        PewterAPI.log("Creating armor modifier: $name (identifier: $identifier)")
        MinecraftForge.EVENT_BUS.register(this)
    }

    override fun getItemsSafe(): List<List<ItemStack>>? {
        return try {
            getItems()
        } catch (e: Exception) {
            null
        }
    }

    override fun safeAdd(stack: ItemStack?) {
        stack?.let { RecipeMatchHolder.addItem(this, it, 1, 1) }
    }

}

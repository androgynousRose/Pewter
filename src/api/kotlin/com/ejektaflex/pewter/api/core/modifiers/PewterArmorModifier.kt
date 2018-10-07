package com.ejektaflex.pewter.api.core.modifiers

import c4.conarm.lib.modifiers.ArmorModifierTrait
import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge

/**
 * Extend this if you want to create a new armor modifier.
 * @param name The unique identifier for this modifier.
 * @param color The color of this modifier. Usually specified in hex (0x44AA77)
 * @param The max level of the armor modifier
 */
@Suppress("LeakingThis")
abstract class PewterArmorModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ArmorModifierTrait(identifier, color, maxLevel, countPerLevel), IPewterArmorModifier {
    /**
     * Override this to add any additional modifier aspects, if needed.
     */
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    /**
     * [getItems] may throw an exception if no items have been specified. This
     * method retrieves all of the items safely.
     */
    override fun getItemsSafe(): List<List<ItemStack>>? {
        return try {
            getItems()
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Safely adds an [ItemStack] with which we can create the modifier.
     */
    override fun safeAdd(stack: ItemStack?) {
        stack?.let { RecipeMatchHolder.addItem(this, it, 1, 1) }
    }

}

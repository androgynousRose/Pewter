package com.ejektaflex.pewter.api.core.modifiers

import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.modifiers.ModifierTrait

/**
 * Extend this if you want to create a new tool modifier.
 */
@Suppress("LeakingThis")
abstract class PewterToolModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ModifierTrait(identifier, color, maxLevel, countPerLevel), IPewterToolModifier {
    init {
        PewterAPI.log("Creating modifier: $name")
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
        stack?.let { addItem(it, 1, 1) }
    }

}
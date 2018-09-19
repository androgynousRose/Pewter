package com.ejektaflex.pewter.api.core.modifiers

import c4.conarm.lib.modifiers.ArmorModifier
import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge

// Does not actually leak
@Suppress("LeakingThis")
abstract class PewterArmorModifier(
        val name: String,
        color: Int,
        maxLevel: Int = 0, // Actually not using maxLevel and countPerLevel yet.
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ArmorModifier(identifier, color), IPewterModifier {
    init {
        PewterAPI.log("Creating armor modifier: $name (id: $identifier)")
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

package com.example.examplemod.ext

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

val String.toItemStack: ItemStack?
    get() {
        val sect = split(":")
        if (sect.size !in 2..3) {
            return null
        }
        // Retrieve meta
        val meta = when (sect.size) {
            2 -> try {
                Integer.parseInt(sect[2])
            } catch (e: Exception) {
                OreDictionary.WILDCARD_VALUE
            }
            else -> 0
        }
        val item = Item.getByNameOrId("${sect[0]}:${sect[1]}")!!
        return ItemStack(item, 1, meta)
    }

val String.isInOreDict: Boolean
    get() = startsWith("ore:")
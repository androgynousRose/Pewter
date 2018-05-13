package com.ejektaflex.pewter.ext

import net.minecraftforge.oredict.OreDictionary
import java.util.ArrayList
import net.minecraft.item.ItemStack

val ItemStack.oreDicts: List<String>
    get() {
        val ids = OreDictionary.getOreIDs(this)
        val names = ArrayList<String>()

        for (id in ids) {
            names.add(OreDictionary.getOreName(id))
        }

        return names
    }
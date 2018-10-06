package com.ejektaflex.pewter.ext

import net.minecraftforge.oredict.OreDictionary
import java.util.ArrayList
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.modifiers.Modifier
import slimeknights.tconstruct.library.modifiers.ModifierNBT
import slimeknights.tconstruct.library.utils.TinkerUtil

val ItemStack.oreDicts: List<String>
    get() {
        val ids = OreDictionary.getOreIDs(this)
        val names = ArrayList<String>()

        for (id in ids) {
            names.add(OreDictionary.getOreName(id))
        }

        return names
    }

inline fun <reified T : Modifier> ItemStack.getModifierIntNBT(): ModifierNBT.IntegerNBT {
    val modData = TinkerUtil.getModifierTag(this, getTinkersModifier<T>().identifier)
    return ModifierNBT.readInteger(modData)
}

fun ItemStack.comesFrom(modName: String): Boolean {
    return item.registryName?.resourceDomain == modName
}


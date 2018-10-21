package com.ejektaflex.pewter.shared.modifiers

import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.core.PewterLogger
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.modules.common.gems.IModGem
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.oredict.OreDictionary

@Suppress("LeakingThis")
abstract class GemArmorModifier(name: String, color: Int) : PewterArmorModifier(name, color), IModGem, TinkerNBTHelper {

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {
        modifyArmorStats(rootCompound, armorMod)
        super.applyEffect(rootCompound, modifierTag)
    }

    override fun configure() {
        oreTags.forEach { tag ->
            OreDictionary.getOres(tag).forEach {
                PewterLogger.verbose("Configured gem '$tag' with ${it.displayName}")
                RecipeMatchHolder.addItem(this, it, 1, 1)
            }
        }
    }

}

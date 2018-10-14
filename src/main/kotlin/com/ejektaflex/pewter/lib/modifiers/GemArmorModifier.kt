package com.ejektaflex.pewter.lib.modifiers

import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.mods.common.gems.IModGem
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
                PewterAPI.log("Configured gem $tag with $it")
                RecipeMatchHolder.addItem(this, it, 1, 1)
            }
        }
    }

}

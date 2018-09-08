package com.ejektaflex.pewter.lib.modifiers

import c4.conarm.lib.utils.RecipeMatchHolder
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.modifiers.base.IModGem
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.oredict.OreDictionary
import slimeknights.tconstruct.library.modifiers.ModifierAspect

@Suppress("LeakingThis")
abstract class GemArmorModifier(name: String, color: Int) : PewterArmorModifier(name, color), IModGem, TinkerNBTHelper {

    init {
        addAspects(ModifierAspect.SingleAspect(this), ModifierAspect.DataAspect(this), ModifierAspect.freeModifier)
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {
        modifyArmorStats(rootCompound, armorMod)

        // If suddenly Armor Modifiers don't hook, I bet it's because I commented this out!
        //super.applyEffect(rootCompound, modifierTag)

    }

    override fun configure() {
        oreTags.forEach { tag ->
            OreDictionary.getOres(tag).forEach {
                println("Configured gem $tag with $it")
                RecipeMatchHolder.addItem(this, it, 1, 1)
            }
        }
    }

}

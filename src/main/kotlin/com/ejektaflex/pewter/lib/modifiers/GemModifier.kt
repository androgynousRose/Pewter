package com.ejektaflex.pewter.lib.modifiers

import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.modifiers.base.IModGem
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.oredict.OreDictionary
import slimeknights.mantle.util.RecipeMatch
import slimeknights.tconstruct.library.modifiers.ModifierAspect

@Suppress("LeakingThis")
abstract class GemModifier(name: String, color: Int) : PewterModifier(name, color), IModGem, TinkerNBTChanger {

    init {
        addAspects(
                ModifierAspect.SingleAspect(this)
        )
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {
        modifyToolStats(rootCompound, toolMod)
        super.applyEffect(rootCompound, modifierTag)

        println("Doot")
    }

    override fun configure() {
        oreTags.forEach { tag ->
            OreDictionary.getOres(tag).forEach {
                addItem(it, 1, 1)
            }
        }
    }

}

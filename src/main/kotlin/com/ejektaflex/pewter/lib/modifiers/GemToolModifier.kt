package com.ejektaflex.pewter.lib.modifiers

import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.modifiers.base.IModGem
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.oredict.OreDictionary
import slimeknights.tconstruct.library.modifiers.ModifierAspect

@Suppress("LeakingThis")
abstract class GemToolModifier(name: String, color: Int) : PewterToolModifier(name, color), IModGem, TinkerNBTHelper {

    init {
        addAspects(
                ModifierAspect.SingleAspect(this)
        )
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {
        modifyToolStats(rootCompound, toolMod)
        super.applyEffect(rootCompound, modifierTag)
    }

    override fun configure() {
        oreTags.forEach { tag ->
            OreDictionary.getOres(tag).forEach {
                addItem(it, 1, 1)
            }
        }
    }

}

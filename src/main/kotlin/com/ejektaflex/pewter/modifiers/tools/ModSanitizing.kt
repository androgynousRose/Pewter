package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.getTinkersModifier
import com.ejektaflex.pewter.ext.set
import com.ejektaflex.pewter.ext.toItem
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import com.ejektaflex.pewter.traits.tools.Warping
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect


class ModSanitizing : PewterModifier("sanitizing", 0xCCA5E6), TinkerNBTChanger {

    init {
        addAspects(
                ModifierAspect.SingleAspect(this)
        )
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound) {
        super.applyEffect(rootCompound, modifierTag)

        if (!rootCompound.hasKey(SANITIZING_TAG)) {
            rootCompound[SANITIZING_TAG] = true
        }
        rootCompound[SANITIZING_TAG] = true
    }

    override fun configure() {
        addItem("thaumcraft:sanity_soap".toItem)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<Warping>() in getTraits(stack!!)
    }

    companion object {
        const val SANITIZING_TAG = "TC_SANITIZING"
    }

}

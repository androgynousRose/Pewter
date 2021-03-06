package com.ejektaflex.pewter.modules.thaumcraft.tool


import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect


class ToolModSanitizing(modName: String) : PewterToolModifier(modName, 0xCCA5E6), TinkerNBTHelper {

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
        safeAdd("thaumcraft:sanity_soap".toItemStack)
    }

    override fun canApplyCustom(stack: ItemStack?): Boolean {
        return getTinkersModifier<ToolTraitWarping>() in getTraits(stack!!)
    }

    companion object {
        const val SANITIZING_TAG = "TC_SANITIZING"
    }

}

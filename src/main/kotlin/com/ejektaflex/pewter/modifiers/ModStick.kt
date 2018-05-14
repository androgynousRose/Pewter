package com.ejektaflex.pewter.modifiers


import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect
import slimeknights.tconstruct.library.utils.HarvestLevels
import slimeknights.tconstruct.library.utils.TagUtil

class ModStick : PewterMod("Shtick", 0xffffff) {
    override val motto = "It's sticky!"
    override val description = "Slight increase to all stats."

    init {
        addAspects(
                ModifierAspect.SingleAspect(this),
                ModifierAspect.DataAspect(this),
                ModifierAspect.freeModifier
        )
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound) {

        val data = TagUtil.getToolStats(rootCompound)
        data.durability += 10

        data.attack += 0.2f
        data.speed += 0.05f

        TagUtil.setToolTag(rootCompound, data.get())
    }
}

package com.ejektaflex.pewter.traits.mixins

import c4.conarm.common.armor.utils.ArmorTagUtil
import c4.conarm.lib.armor.ArmorNBT
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.tools.ToolNBT
import slimeknights.tconstruct.library.utils.TagUtil

interface TinkerNBTChanger {

    fun modifyArmorStats(armor: ItemStack, func: (original: ArmorNBT, current: NBTTagCompound) -> Unit) {
        val currentTag = ArmorTagUtil.getArmorStats(armor).get()
        func(ArmorTagUtil.getOriginalArmorStats(armor), currentTag)
        TagUtil.setToolTag(armor, currentTag)
    }

    fun modifyToolStats(tool: ItemStack, func: (original: ToolNBT, current: NBTTagCompound) -> Unit) {
        func(TagUtil.getOriginalToolStats(tool), TagUtil.getToolTag(tool))
    }

    fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> Unit) {
        val toolData = TagUtil.getToolStats(root)
        toolData.apply(func)
        TagUtil.setToolTag(root, toolData.get())
    }

}
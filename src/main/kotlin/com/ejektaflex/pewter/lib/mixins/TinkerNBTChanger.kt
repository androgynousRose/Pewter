package com.ejektaflex.pewter.lib.mixins

import c4.conarm.common.armor.utils.ArmorTagUtil
import c4.conarm.lib.armor.ArmorNBT
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagString
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.IModifier
import slimeknights.tconstruct.library.modifiers.Modifier
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

    fun hasToolTag(tool: ItemStack, tagName: String): Boolean {
        return TagUtil.getToolTag(tool).hasKey(tagName)
    }

    fun hasTag(tool: ItemStack, tagName: String): Boolean {
        return TagUtil.getTagSafe(tool).hasKey(tagName)
    }

    fun modifyArmorStats(root: NBTTagCompound, func: ArmorNBT.() -> Unit) {
        val armorData = ArmorTagUtil.getArmorStats(root)
        armorData.apply(func)
        TagUtil.setToolTag(root, armorData.get())
    }

    fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> Unit) {
        val toolData = TagUtil.getToolStats(root)
        toolData.apply(func)
        TagUtil.setToolTag(root, toolData.get())
    }

    fun baseMaterials(stack: ItemStack): List<String> {
        return TagUtil.getBaseMaterialsTagList(stack).filter { it is NBTTagString }.map { (it as NBTTagString).string }
    }

    /*
    fun getModifiers(stack: ItemStack): List<String> {
        return TagUtil.getModifiersTagList(stack).filter { it is NBTTagString }.map { (it as NBTTagString).string }
    }
    */

    /*
    fun getTraits(stack: ItemStack): List<String> {
        return TagUtil.getTraitsTagList(stack).filter { it is NBTTagString }.map { (it as NBTTagString).string }
    }
    */


    fun getTraits(stack: ItemStack): List<IModifier> {
        return TagUtil.getTraitsTagList(stack).filter { it is NBTTagString }.map {
            val ident = (it as NBTTagString).string
            TinkerRegistry.getModifier(ident)
        }.filterNotNull()
    }



}
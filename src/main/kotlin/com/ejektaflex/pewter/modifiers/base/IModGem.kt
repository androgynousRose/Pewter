package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.ext.toItemStack
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModGem {

    val gemMeta: Int

    val gem: ItemStack?
        get() = "biomesoplenty:gem:$gemMeta".toItemStack

    val toolMod: ToolNBT.() -> Unit

    val armorMod: ArmorNBT.() -> Unit

}
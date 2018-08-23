package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.mixins.ConfigurableModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModGem {

    val oreTags: List<String>

    val toolMod: ToolNBT.() -> Unit

    val armorMod: ArmorNBT.() -> Unit


}
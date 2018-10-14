package com.ejektaflex.pewter.mods.common.gems

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModGem {

    val oreTags: List<String>

    val toolMod: ToolNBT.() -> Unit

    val armorMod: ArmorNBT.() -> Unit


}
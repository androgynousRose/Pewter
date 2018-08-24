package com.ejektaflex.pewter.modifiers.base.gems

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.modifiers.base.IModGem
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModMalachite : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemMalachite")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 25
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 1f
            durability = (durability * 1.05).toInt()
        }

}
package com.ejektaflex.pewter.modifiers.base.gems

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.modifiers.base.IModGem
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModPeridot : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemPeridot")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 150
            speed += 0.25f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 1.5f
            durability = (durability * 1.075).toInt()
        }

}
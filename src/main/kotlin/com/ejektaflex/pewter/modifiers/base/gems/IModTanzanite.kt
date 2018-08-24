package com.ejektaflex.pewter.modifiers.base.gems

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.modifiers.base.IModGem
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModTanzanite : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemTanzanite")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 250
            speed += 0.8f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 1.5f
            durability = (durability * 1.125).toInt()
        }

}
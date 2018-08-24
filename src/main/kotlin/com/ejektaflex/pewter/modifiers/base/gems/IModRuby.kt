package com.ejektaflex.pewter.modifiers.base.gems

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.modifiers.base.IModGem
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModRuby : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemRuby")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 350
            attack += 0.15f
            speed -= 0.25f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2f
            durability += 35
        }

}
package com.ejektaflex.pewter.modules.common.gems

import c4.conarm.lib.armor.ArmorNBT
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
            durability = (durability * 1.175).toInt()
        }

}
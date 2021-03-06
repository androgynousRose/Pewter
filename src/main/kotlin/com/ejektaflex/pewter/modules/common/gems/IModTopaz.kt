package com.ejektaflex.pewter.modules.common.gems

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModTopaz : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemTopaz")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 300
            speed += 0.4f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 1.5f
            durability = (durability * 1.175).toInt()
        }

}


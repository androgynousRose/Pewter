package com.ejektaflex.pewter.modules.common.gems

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModSapphire : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemSapphire")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 350
            attack += 0.5f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2.5f
            durability = (durability * 1.175).toInt()
        }

}
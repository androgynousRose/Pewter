package com.ejektaflex.pewter.mods.commongems

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModAmethyst : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemAmethyst")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 400
            attack += 1f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2.5f
            durability = (durability * 1.2).toInt()
        }

}


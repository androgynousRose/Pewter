package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModPeridot : IModGem {

    override val gemMeta: Int
        get() = 2

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 150
            speed += 0.25f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2f
            durability += 10
        }

}
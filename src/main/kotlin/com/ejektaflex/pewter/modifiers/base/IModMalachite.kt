package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModMalachite : IModGem {

    override val gemMeta: Int
        get() = 5

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 25
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2f
            durability += 10
        }

}
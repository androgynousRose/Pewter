package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModSapphire : IModGem {

    override val gemMeta: Int
        get() = 6

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 350
            attack += 0.5f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2f
            durability += 10
        }

}
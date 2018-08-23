package com.ejektaflex.pewter.modifiers.base.gems

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.modifiers.base.IModGem
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModEnderAmethyst : IModGem {

    override val oreTags: List<String>
        get() = listOf("gemAmethyst")

    override val toolMod: ToolNBT.() -> Unit
        get() = {
            durability += 400
            attack += 1f
        }

    override val armorMod: ArmorNBT.() -> Unit
        get() = {
            defense += 2f
            durability += 10
        }

}
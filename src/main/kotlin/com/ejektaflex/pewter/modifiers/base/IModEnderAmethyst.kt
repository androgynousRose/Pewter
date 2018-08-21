package com.ejektaflex.pewter.modifiers.base

import c4.conarm.lib.armor.ArmorNBT
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.traits.base.SharedTrait
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT

interface IModEnderAmethyst : IModGem {

    override val gemMeta: Int
        get() = 0

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
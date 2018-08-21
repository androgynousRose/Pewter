package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModPeridot : BOPGemModifier("peridot", 0xCCA5E6) {

    override val gem: ItemStack? = "biomesoplenty:gem:2".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 150
        speed += 0.25f
    }

}


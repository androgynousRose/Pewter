package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModRuby : BOPGemModifier("ruby", 0xCCA5E6) {

    override val gem: ItemStack? = "biomesoplenty:gem:1".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 350
        attack += 0.15f
        speed -= 0.25f
    }

}


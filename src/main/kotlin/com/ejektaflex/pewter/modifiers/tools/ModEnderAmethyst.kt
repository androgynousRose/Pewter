package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModEnderAmethyst : BOPGemModifier("enderamethyst", 0xE051ED) {

    override val gem: ItemStack? = "biomesoplenty:gem:0".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 400
        attack += 1f
    }

    // TODO: 25-50% Durability bonus with end stone / end rod

}


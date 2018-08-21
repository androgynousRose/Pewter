package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModTopaz : BOPGemModifier("topaz", 0xCCA5E6) {

    override val gem: ItemStack? = "biomesoplenty:gem:3".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 300
        speed += 0.4f
    }

}


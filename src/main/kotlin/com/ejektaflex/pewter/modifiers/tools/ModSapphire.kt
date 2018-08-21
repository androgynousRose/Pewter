package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModSapphire : BOPGemModifier("sapphire", 0x2481AD) {

    override val gem: ItemStack? = "biomesoplenty:gem:6".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 350
        attack += 0.5f
    }

}


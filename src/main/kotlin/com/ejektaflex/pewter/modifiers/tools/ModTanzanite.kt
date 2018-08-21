package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.lib.modifiers.BOPGemModifier
import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.tools.ToolNBT


class ModTanzanite : BOPGemModifier("tanzanite", 0x7E23D4) {

    override val gem: ItemStack? = "biomesoplenty:gem:4".toItemStack

    override val mod: ToolNBT.() -> Unit = {
        durability += 250
        speed += 0.8f
    }

}


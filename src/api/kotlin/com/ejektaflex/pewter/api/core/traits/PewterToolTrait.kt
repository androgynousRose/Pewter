package com.ejektaflex.pewter.api.core.traits

import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.modifiers.ModifierTrait
import slimeknights.tconstruct.library.utils.TagUtil

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterToolTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' })
    : ModifierTrait(identifier, color), IPewterToolTrait {
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    fun baseStatsOf(tool: ItemStack?) = TagUtil.getOriginalToolStats(tool)!!

    fun statsOf(tool: ItemStack?) = TagUtil.getToolStats(tool)!!

}

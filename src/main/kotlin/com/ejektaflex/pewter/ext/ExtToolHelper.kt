package com.ejektaflex.pewter.ext

import net.minecraft.item.ItemStack
import slimeknights.tconstruct.library.utils.ToolHelper

fun isAtMaxDurability(tool: ItemStack) = ToolHelper.getCurrentDurability(tool) == ToolHelper.getMaxDurability(tool)


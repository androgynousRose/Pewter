package com.ejektaflex.pewter.modifiers

import com.ejektaflex.pewter.Pewter
import net.minecraftforge.common.MinecraftForge
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.ModifierTrait
import slimeknights.tconstruct.tools.modifiers.ToolModifier

// This does not actually leak
@Suppress("LeakingThis")
abstract class PewterModTrait(
        val name: String,
        color: Int,
        maxLevel: Int = 0,
        countPerLevel: Int = 0,
        identifier: String = name.toLowerCase().filter { it != ' ' }
) : ModifierTrait(identifier, color, maxLevel, countPerLevel), ConfigurableModifier {
    init {
        Pewter.LOGGER.info("Creating modifier: $name")
        MinecraftForge.EVENT_BUS.register(this)
    }
}
package com.ejektaflex.pewter.ext

import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.IModifier
import slimeknights.tconstruct.library.modifiers.Modifier

inline fun <reified T : Modifier> getTinkersModifier(): IModifier {
    return TinkerRegistry.getAllModifiers().first { it is T }
}

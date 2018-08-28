package com.ejektaflex.pewter.ext

import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.IModifier
import slimeknights.tconstruct.library.modifiers.Modifier

inline fun <reified T : Modifier> getTinkersModifier(): IModifier {
    return TinkerRegistry.getAllModifiers().first { it is T }
}

inline fun <reified T : Any> getTinkersModifiers(): List<T> {
    return TinkerRegistry.getAllModifiers().filter { it is T }.map { it as T }
}


fun getTinkersModifier(id: String): IModifier {
    return TinkerRegistry.getAllModifiers().first { it.identifier == id }
}

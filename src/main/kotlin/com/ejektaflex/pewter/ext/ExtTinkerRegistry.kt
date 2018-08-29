package com.ejektaflex.pewter.ext

import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.logic.MaterialRegistrar
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.library.modifiers.IModifier
import slimeknights.tconstruct.library.modifiers.Modifier

inline fun <reified T : Modifier> getTinkersModifier(): IModifier {
    return TinkerRegistry.getAllModifiers().first { it is T }
}

inline fun <reified T : Material> getTinkersMaterial(): Material {
    return TinkerRegistry.getAllMaterials().first { it is T }
}


inline fun <reified T : Modifier> getPewterModifier(): Modifier {
    return PewterModifiers.content.first { it is T }
}

inline fun <reified T : MaterialRegistrar> getPewterTrait(): Modifier {
    return PewterModifiers.content.first { it is T }
}


inline fun <reified T : Any> getTinkersModifiers(): List<T> {
    return TinkerRegistry.getAllModifiers().filter { it is T }.map { it as T }
}


fun getTinkersModifier(id: String): IModifier {
    return TinkerRegistry.getAllModifiers().first { it.identifier == id }
}


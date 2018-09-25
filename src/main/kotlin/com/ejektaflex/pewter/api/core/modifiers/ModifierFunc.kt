package com.ejektaflex.pewter.api.core.modifiers

class ModifierFunc<T : IPewterModifier>(var identifier: String, val func: String.() -> T) {
    fun create() = func(identifier)
}
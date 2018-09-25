package com.ejektaflex.pewter.api.modifiers

import com.ejektaflex.pewter.api.core.modifiers.IPewterModifier

class ModifierFunc<T : IPewterModifier>(var identifier: String, val func: String.() -> T) {
    fun create() = func(identifier)
}
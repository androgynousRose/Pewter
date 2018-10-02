package com.ejektaflex.pewter.api.core.modifiers

import com.ejektaflex.pewter.api.core.IPewterBaseEffect

class ModifierFunc<T : IPewterBaseEffect>(var identifier: String, val func: String.() -> T) {
    fun create() = func(identifier)
}
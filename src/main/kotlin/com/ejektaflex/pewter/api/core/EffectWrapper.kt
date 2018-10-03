package com.ejektaflex.pewter.api.core

/**
 * This is a simple wrapper around an effect that allows you to store a
 * reference to an effect without instantiating it. This is needed because
 * these effects get registered into registries when they're instantiated.
 * Multiple instantiations of a tool effect will then cause an error due
 * to how they're implemented in TiC/ConArm.
 */
class EffectWrapper<T : IPewterBaseEffect>(var identifier: String, val func: String.() -> T) {
    fun create() = func(identifier)
}



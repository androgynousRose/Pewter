package com.example.examplemod.dsl

open class DSL<T : DSL<T>>(initFunc: DSL<T>.() -> Unit = {}) {
    init {
        apply(initFunc)
    }
}
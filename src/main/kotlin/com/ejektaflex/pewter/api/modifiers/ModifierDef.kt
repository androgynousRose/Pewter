package com.ejektaflex.pewter.api.modifiers

import slimeknights.tconstruct.library.modifiers.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.KFunction1

class ModifierDef<T : Modifier> {

    var identifier: String
    private var modClass: Class<T>? = null
    private var modFact: KFunction1<String, T>? = null

    private constructor(modName: String) {
        identifier = modName
    }

    constructor(modName: String, clazz: Class<T>) : this(modName) {
        modClass = clazz
    }

    constructor(modName: String, fact: KFunction1<String, T>) : this(modName) {
        modFact = fact
    }

    constructor(name: String, kClazz: KClass<T>) : this(name, kClazz.java)

    fun create(): T {
        return when {
            modClass != null -> modClass!!.getConstructor(String::class.java).newInstance(identifier)
            modFact != null -> modFact?.invoke(identifier)!!
            else -> throw Exception("Can't create modifier $identifier, as you used an unsuitable constructor")
        }
    }

}
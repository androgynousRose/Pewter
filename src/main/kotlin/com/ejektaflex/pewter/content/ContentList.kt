package com.ejektaflex.pewter.content

import net.minecraftforge.fml.common.Loader

abstract class ContentList<T> {
    abstract val content: Map<String, MutableList<T>>


    val inListForm: List<T>
        get() {
            return content.flatMap { entries -> entries.value }
        }

    val flattened: List<Pair<String, T>>
        get() {
            return content.map { entry -> entry.value.map { entry.key to it } }.flatten()
        }

    val loaded: List<T>
        get() = content.filter { Loader.isModLoaded(it.key) }.flatMap { entry -> entry.value }

    /*
    fun materialsMatching(names: List<String>): List<Pair<String, MaterialDSL>> {
        return flattened.filter { it.second.material.name in names }
    }
    */


}
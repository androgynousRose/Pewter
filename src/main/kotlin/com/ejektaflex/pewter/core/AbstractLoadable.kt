package com.ejektaflex.pewter.core

abstract class AbstractLoadable<M, D> {

    open val internalContent: MutableList<D> = mutableListOf()

    var content = listOf<M>()
        private set

    var isLoaded: Boolean = false
        private set

    abstract fun transformContent(items: List<D>): List<M>

    fun setup() {
        isLoaded = true
        content = transformContent(internalContent)
    }

    /**
     * Allows querying for a content object
     */
    abstract operator fun get(id: String): M?

    /**
     * Allows iterating over a content object
     */
    operator fun iterator() = content.iterator()

}
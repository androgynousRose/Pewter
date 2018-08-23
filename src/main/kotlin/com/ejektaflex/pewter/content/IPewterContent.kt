package com.ejektaflex.pewter.content

interface IPewterContent<T> {
    val content: List<T>

    fun loadContent(): List<T> {
        return content // Yep
    }

    operator fun iterator() = content.iterator()

}
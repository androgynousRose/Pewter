package com.ejektaflex.pewter.command

class Cycler<T : Any>(val content: List<T>) {

    var counter: Int = -1
        private set

    init {
        if (content.isEmpty()) {
            throw Exception("Can't cycle an empty list!")
        }
    }

    fun cycle(): T {
        if (counter == Int.MAX_VALUE) {
            counter = 0
        } else {
            counter++
        }
        return content[counter % content.size]
    }


}
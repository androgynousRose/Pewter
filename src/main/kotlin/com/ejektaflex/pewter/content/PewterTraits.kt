package com.ejektaflex.pewter.content

import slimeknights.tconstruct.library.modifiers.Modifier

object PewterTraits : AbstractLoadable<Modifier, Modifier>() {

    override fun get(id: String): Modifier? {
        return PewterTraits.content.find { it.identifier == id }
    }

    override fun transformContent(items: List<Modifier>) = items

}
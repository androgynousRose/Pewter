package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.lib.AbstractLoadable
import slimeknights.tconstruct.library.modifiers.IModifier

object PewterTraits : AbstractLoadable<IPewterTrait, IPewterTrait>() {

    override fun get(id: String): IPewterTrait? {
        return PewterTraits.content.find { it.identifier == id }
    }

    override fun transformContent(items: List<IPewterTrait>) = items

}
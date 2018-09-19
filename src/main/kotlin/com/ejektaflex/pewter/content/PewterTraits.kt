package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import slimeknights.tconstruct.library.modifiers.IModifier

object PewterTraits : AbstractLoadable<IModifier, IPewterTrait>() {

    override fun get(id: String): IModifier? {
        return PewterTraits.content.find { it.identifier == id }
    }

    override fun transformContent(items: List<IPewterTrait>) = items

}
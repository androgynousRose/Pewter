package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.lib.AbstractLoadable

object PewterTraits : AbstractLoadable<IPewterTrait, EffectWrapper<out IPewterTrait>>() {

    override fun get(id: String): IPewterTrait? {
        return PewterTraits.content.find { it.identifier == id }
    }

    override fun transformContent(items: List<EffectWrapper<out IPewterTrait>>): List<IPewterTrait> {
        return items.map { it.create() }
    }

}
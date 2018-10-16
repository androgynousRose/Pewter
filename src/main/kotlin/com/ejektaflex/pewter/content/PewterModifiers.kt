package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.api.core.modifiers.IPewterModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.lib.AbstractLoadable
import com.ejektaflex.pewter.lib.PewterLogger

object PewterModifiers : AbstractLoadable<IPewterModifier, EffectWrapper<out IPewterModifier>>() {

    private const val armorSuffix = "_armor"

    override fun get(id: String): IPewterModifier? {
        return content.find { it.identifier == id }
    }

    override fun transformContent(items: List<EffectWrapper<out IPewterModifier>>): List<IPewterModifier> {
        return items.asSequence().mapNotNull {
            // Remove modifiers that have been blacklisted
            if (Configs.main.hasBlacklistedModifier(it.identifier)) {
                return@mapNotNull null
            }

            // Remove ConArm mods if the mod isn't loaded
            if (it.identifier.endsWith(armorSuffix) && !Configs.main.isUsingConArm()) {
                return@mapNotNull null
            }

            // Trim armor identifier as it gets redundantly added later on
            if (it.identifier.endsWith(armorSuffix)) {
                it.identifier = it.identifier.dropLast(armorSuffix.length)
            }

            it
        }.map {
            it.create().also { modif -> PewterLogger.verbose("Added Modifier for registration: ${modif.identifier}") }
        }.toList()
    }

}

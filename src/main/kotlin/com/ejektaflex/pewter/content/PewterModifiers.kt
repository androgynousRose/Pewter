package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.modifiers.ModifierDef
import com.ejektaflex.pewter.lib.InternalPewterAPI
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers : AbstractLoadable<Modifier, ModifierDef<out Modifier>>() {

    private const val armorSuffix = "_armor"

    override fun get(id: String): Modifier? {
        return content.find { it.identifier == id }
    }

    override fun transformContent(items: List<ModifierDef<out Modifier>>): List<Modifier> {
        return items.asSequence().mapNotNull {
            // Remove modifiers that have been blacklisted
            if (Pewter.hasBlacklistedModifier(it.identifier)) {
                return@mapNotNull null
            }

            // Remove ConArm mods if the mod isn't loaded
            if (it.identifier.endsWith(armorSuffix) && !Pewter.isUsingConArm()) {
                return@mapNotNull null
            }

            // Trim armor identifier as it gets redundantly added later on
            if (it.identifier.endsWith(armorSuffix)) {
                it.identifier = it.identifier.dropLast(armorSuffix.length)
            }

            it
        }.map {
            it.create()
        }.toList()
    }

}

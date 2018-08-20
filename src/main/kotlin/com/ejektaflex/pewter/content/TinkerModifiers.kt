package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.modifiers.tools.ModSanitized
import slimeknights.tconstruct.library.modifiers.Modifier

class TinkerModifiers : ContentList<Modifier>() {
    override val content = mapOf(
            "thaumcraft" to mutableListOf<Modifier>(
                    ModSanitized()
            )
    )
}

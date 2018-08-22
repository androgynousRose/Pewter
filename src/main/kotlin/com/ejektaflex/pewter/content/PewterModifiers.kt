package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterModifiers {
    val content: List<Modifier>
        get() {
            return listOf(
                    ModSanitizing(),

                    ModEnderAmethyst(),
                    ModRuby(),
                    ModPeridot(),
                    ModTopaz(),
                    ModTanzanite(),
                    ModMalachite(),
                    ModSapphire(),
                    ModAmber()
            )
        }
}

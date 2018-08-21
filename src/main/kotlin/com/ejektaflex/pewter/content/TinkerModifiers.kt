package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.modifiers.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

class TinkerModifiers : ContentList<Modifier>() {
    override val content = mapOf(
            "thaumcraft" to mutableListOf<Modifier>(
                    ModSanitizing()
            ),
            "biomesoplenty" to mutableListOf<Modifier>(
                    // BOP
                    ModEnderAmethyst(),
                    ModRuby(),
                    ModPeridot(),
                    ModTopaz(),
                    ModTanzanite(),
                    ModMalachite(),
                    ModSapphire(),
                    ModAmber()
            )
    )
}

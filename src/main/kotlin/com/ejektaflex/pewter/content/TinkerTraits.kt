package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.traits.armor.*
import com.ejektaflex.pewter.traits.tools.*
import net.minecraftforge.fml.common.Loader
import slimeknights.tconstruct.library.modifiers.Modifier

object TinkerTraits {

    val traits = mutableListOf<Modifier>(
            Brilliance(),
            HeatLover(),
            Polluted(),
            Essentia(),
            Aural(),
            Warping(),
            Sapping(),
            Corrosive(),
            Sparking(),
            Gritty()
    )

    init {
        if (Loader.isModLoaded("conarm")) {
            val conArmTraits = listOf(
                    ArmorHeatLover(),
                    ArmorInflamed(),
                    ArmorCorrosive(),
                    ArmorVisBarrier(),
                    ArmorManiacal(),
                    ArmorSplash()
            )
            traits.addAll(conArmTraits)
        }
    }

}
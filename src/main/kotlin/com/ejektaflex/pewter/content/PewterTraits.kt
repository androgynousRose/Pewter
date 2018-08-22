package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.traits.armor.*
import com.ejektaflex.pewter.traits.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

class PewterTraits {

    val traits = mutableListOf<Modifier>(
            Brilliance(),
            Buzzing(),
            HeatLover(),
            Polluted(),
            Essentia(),
            Aural(),
            Warping(),
            Sapping(),
            Corrosive(),
            Sparking(),
            Gritty(),
            Heavyweight(),
            Attuned(),
            ManaInfused(),
            Basher(),
            ManaHarvest()
    )

    init {
        if (Pewter.CONFIG.MAIN.conarmIntegration) {
            traits.addAll(listOf(
                    ArmorHeatLover(),
                    ArmorInflamed(),
                    ArmorCorrosive(),
                    ArmorVisBarrier(),
                    ArmorManiacal(),
                    ArmorSplash(),
                    ArmorManaInfused(),
                    ArmorAdapting()
            ))
        }
    }

}
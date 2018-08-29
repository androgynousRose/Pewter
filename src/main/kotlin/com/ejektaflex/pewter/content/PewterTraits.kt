package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.traits.armor.*
import com.ejektaflex.pewter.traits.tools.*
import slimeknights.tconstruct.library.modifiers.Modifier

object PewterTraits : IPewterContent<Modifier> {

    override fun get(id: String): Modifier? {
        return PewterTraits.content.find { it.identifier == id }
    }

    override val content: List<Modifier> by lazy {
        val traits = mutableListOf<Modifier>(
                //Brilliance(),
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

        if (Pewter.CONFIG.MAIN.conarmIntegration) {
            traits += listOf(
                    ArmorHeatLover(),
                    ArmorInflamed(),
                    ArmorCorrosive(),
                    ArmorVisBarrier(),
                    ArmorManiacal(),
                    ArmorSplash(),
                    ArmorManaInfused(),
                    ArmorAdapting(),
                    ArmorEnvious(),
                    ArmorTerra()
            )
        }

        return@lazy traits
    }

}
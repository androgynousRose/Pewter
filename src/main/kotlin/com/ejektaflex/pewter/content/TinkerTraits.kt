package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.traits.armor.ArmorCorrosive
import com.ejektaflex.pewter.traits.armor.ArmorInflamed
import com.ejektaflex.pewter.traits.armor.ArmorKindle
import com.ejektaflex.pewter.traits.tools.*

class TinkerTraits {

    companion object {
        val traits = listOf(
                Brilliance(),
                Kindle(),
                Polluted(),
                Essentia(),
                Aural(),
                Warping(),
                Sapping(),
                Corrosive(),
                Sparking(),
                Gritty(),

                ArmorKindle(),
                ArmorInflamed(),
                ArmorCorrosive()
        )
    }

}
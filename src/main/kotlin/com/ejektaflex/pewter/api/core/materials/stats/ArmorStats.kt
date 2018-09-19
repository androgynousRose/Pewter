package com.ejektaflex.pewter.api.core.materials.stats

class ArmorStats {

    data class CoreStats(var durability: Float = 1f, var defense: Float = 1f)
    data class PlatesStats(var modifier: Float = 1f, var durability: Float = 1f, var toughness: Float = 1f)
    data class TrimStats(var extraDurability: Float = 0f)

    val core = CoreStats()
    val plates = PlatesStats()
    val trim = TrimStats()

}
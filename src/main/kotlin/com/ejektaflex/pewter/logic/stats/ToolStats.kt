package com.ejektaflex.pewter.logic.stats

class ToolStats {

    data class BowStats(var speed: Float = 0f, var range: Float = 0f, var bonusDamage: Float = 0f)
    data class FletchingStats(var accuracy: Float = 0f, var modifier: Float = 0f)
    data class HeadStats(var attackDamage: Float = 0f, var speed: Float = 0f, var durability: Int = 0, var harvestLevel: Int = 0)
    data class HandleStats(var modifier: Float = 1f, var durability: Int = 0)
    data class ArrowShaftStats(var modifier: Float = 0f, var bonusAmmo: Int = 0)
    data class BowStringStats(var modifier: Float = 1f)
    data class ExtraStats(var durability: Int = 0)

    //data class HandleStats()

    val bow = BowStats()
    val fletching = FletchingStats()
    val head = HeadStats()
    val handle = HandleStats()
    val arrowShaft = ArrowShaftStats()
    val bowstring = BowStringStats()
    val extra = ExtraStats()

}
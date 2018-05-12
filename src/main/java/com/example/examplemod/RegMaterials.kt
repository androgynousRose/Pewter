package com.example.examplemod

import slimeknights.tconstruct.shared.FluidsClientProxy

class RegMaterials {


    companion object {
        const val liquidBaseValue = 144
        enum class LiquidAmount(val mb: Int) {
            Liquid(liquidBaseValue),
            Nugget(liquidBaseValue / 9),
            Ore(liquidBaseValue * 1), // Should later be times TCon multiplier value
            Block(liquidBaseValue * 9)
        }
    }
}
package com.ejektaflex.pewter.traits.tools

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.aura.AuraHelper
import kotlin.math.log10
import kotlin.math.min
import kotlin.math.pow


class Attuned : PewterTrait("attuned", 0xE18EFF) {
    override fun onToolHeal(tool: ItemStack?, amount: Int, newAmount: Int, entity: EntityLivingBase): Int {
        val netVis = AuraHelper.getVis(entity.world, entity.position) - AuraHelper.getFlux(entity.world, entity.position)
        val visLog = log10(min(1f, netVis))
        val visMult = min(1f, visLog.pow(0.4f))

        // 20 vis gives visMult of 1.11
        // 60 vis gives visMult of 1.26
        // 100 vis gives visMult of 1.32
        // 200 vis gives visMult of 1.39

        return (super.onToolHeal(tool, amount, newAmount, entity) * visMult).toInt()

    }
}
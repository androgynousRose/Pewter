package com.ejektaflex.pewter.traits.mixins

import net.minecraft.entity.EntityLivingBase
import net.minecraftforge.event.world.BlockEvent
import thaumcraft.api.aura.AuraHelper

interface AuraExchanger {

    fun addFluxFor(e: EntityLivingBase, amount: Float) {
        AuraHelper.polluteAura(e.world, e.position, amount, true)
    }

    fun addFluxFor(e: BlockEvent, amount: Float) {
        AuraHelper.polluteAura(e.world, e.pos, amount, true)
    }

    fun drainVisFor(e: EntityLivingBase, amount: Float) {
        AuraHelper.drainVis(e.world, e.position, amount, false)
    }

}
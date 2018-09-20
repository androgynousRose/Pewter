package com.ejektaflex.pewter.modifiers.base.methods

import net.minecraft.entity.EntityLivingBase

interface IModAquaNight {
    fun isRightSetting(player: EntityLivingBase): Boolean {
        return player.world.canBlockSeeSky(player.position) && !player.world.isDaytime
    }
}
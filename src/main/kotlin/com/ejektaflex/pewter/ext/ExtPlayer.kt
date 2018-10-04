package com.ejektaflex.pewter.ext

import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.Vec3d
import net.minecraftforge.common.capabilities.Capability


fun EntityPlayer.lookingAt(dist: Double): RayTraceResult? {
    val eyes = getPositionEyes(1.0f)
    return entityWorld.rayTraceBlocks(eyes, eyes.add(Vec3d(lookVec.x * dist, lookVec.y * dist, lookVec.z * dist)))
}

fun <CAP, T : Capability<CAP>> EntityLivingBase.ifHasCapability(cap: T, func: CAP.() -> Unit) {
    getCapability<CAP>(cap, null)?.apply(func)
}

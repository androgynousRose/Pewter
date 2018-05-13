package com.ejektaflex.pewter.ext

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.math.Vec3d


fun EntityPlayer.lookingAt(dist: Double): RayTraceResult? {
    val eyes = getPositionEyes(1.0f)
    return entityWorld.rayTraceBlocks(eyes, eyes.add(Vec3d(lookVec.x * dist, lookVec.y * dist, lookVec.z * dist)))
}

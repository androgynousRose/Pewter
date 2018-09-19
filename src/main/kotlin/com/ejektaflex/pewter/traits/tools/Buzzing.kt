package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.api.core.traits.PewterProjectileTrait
import net.minecraft.util.EnumParticleTypes
import net.minecraft.world.World
import slimeknights.tconstruct.library.entity.EntityProjectileBase
import slimeknights.tconstruct.library.modifiers.Modifier


class Buzzing : PewterProjectileTrait("buzzing", 0x6BBEBF) {

    override fun onMovement(projectile: EntityProjectileBase, world: World, slowdown: Double) {
        val amt = 0.13f
        projectile.motionX *= smallVariance(amt, slowdown)
        projectile.motionY *= smallVariance(amt, slowdown)
        projectile.motionZ *= smallVariance(amt, slowdown)

        //projectile.motionY += projectile.gravity * 95.0 / 100.0

        if (world.isRemote && Modifier.random.nextInt(2) == 0) {
            val vx = (Modifier.random.nextFloat() - 0.5f) / 15.0
            val vy = Modifier.random.nextFloat() / 15.0
            val vz = (Modifier.random.nextFloat() - 0.5f) / 15.0
            world.spawnParticle(EnumParticleTypes.SPIT,
                    projectile.posX,
                    projectile.posY,
                    projectile.posZ,
                    vx, vy, vz)
        }
    }

    private fun smallVariance(amt: Float, slowdown: Double): Double {
        return ((1f - amt) + random.nextFloat() * amt) / slowdown
    }

}


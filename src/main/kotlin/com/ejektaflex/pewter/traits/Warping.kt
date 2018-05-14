package com.ejektaflex.pewter.traits

import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import thaumcraft.api.ThaumcraftApi
import thaumcraft.api.capabilities.IPlayerWarp


class Warping : PewterTrait("Warping", 0x2A114A) {
    override val motto = "Don't Forget The Soap!"
    override val description = "Tool usage slowly warps the user's mind."

    override fun onToolDamage(tool: ItemStack?, damage: Int, newDamage: Int, entity: EntityLivingBase): Int {

        if (entity is EntityPlayer) {
            if (random.nextFloat() < chance) {
                ThaumcraftApi.internalMethods.addWarpToPlayer(entity, 2, IPlayerWarp.EnumWarpType.TEMPORARY)
            }
        }

        return super.onToolDamage(tool, damage, newDamage, entity)
    }

    companion object {
        const val chance = 0.05f
    }

}
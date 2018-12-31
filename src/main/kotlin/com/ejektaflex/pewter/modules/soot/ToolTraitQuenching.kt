package com.ejektaflex.pewter.modules.soot

import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import net.minecraft.entity.EntityLivingBase
import net.minecraft.init.SoundEvents
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import slimeknights.tconstruct.common.Sounds

class ToolTraitQuenching(name: String) : PewterToolTrait(name, 0xFFB337), TinkerNBTHelper {

    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase?, damage: Float, isCritical: Boolean) {
        target?.let {
            if (target.isBurning) {
                println("Is burning; Setting time to 0")
                target.attackEntityFrom(DamageSource.GENERIC, 2.5f) // Apparently this is full hearts
                Sounds.playSoundForAll(target, SoundEvents.BLOCK_LAVA_EXTINGUISH, 0.8f, 1f)
                target.extinguish()
            }
        }
    }


}


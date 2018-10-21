package com.ejektaflex.pewter.modules.mekanism

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools

class ArmorTraitGrounded(name: String) : PewterArmorTrait(name, 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        if (player?.world?.isRemote == true) { return 0f }
        var divFactor = 1f
        if (player != null && source != null) {
            if (player.onGround && source.isProjectile) {
                divFactor = 1.1f
                TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ARMOR, player, 1)
            }
        }
        return super.onDamaged(armor, player, source, damage, newDamage / divFactor, evt)
    }

}
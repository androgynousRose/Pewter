package com.ejektaflex.pewter.mods.thebetweenlands.armor

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools

class ArmorTraitSplash : PewterArmorTrait("splash", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        val enemy = source.trueSource
        enemy?.let {
            if (player.isInWater) {
                TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ELECTRO, enemy, 1)
                enemy.attackEntityFrom(DamageSource.MAGIC, damage / 3f)
            }
        }
        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

}
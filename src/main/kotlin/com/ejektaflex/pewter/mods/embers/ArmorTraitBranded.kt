package com.ejektaflex.pewter.mods.embers

import c4.conarm.common.armor.utils.ArmorHelper
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import kotlin.math.ceil

class ArmorTraitBranded(name: String) : PewterArmorTrait(name, 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {

        val divFactor = if (player!!.health < 8f) {
            val totalToughs = armorSetStats(player).map { it.toughness }.sum()
            val damageDiv = (1 + totalToughs / 5)
            ArmorHelper.damageArmor(armor, source, ceil(damageDiv).toInt(), player, player.armorInventoryList.indexOf(armor))
            source?.let { TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ELECTRO, it.trueSource, 1) }
            damageDiv
        } else {
            1f
        }

        return super.onDamaged(armor, player, source, damage, newDamage / divFactor, evt)
    }

}
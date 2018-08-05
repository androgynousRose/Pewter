package com.ejektaflex.pewter.traits.armor

import c4.conarm.common.armor.utils.ArmorHelper
import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ext.temperature
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent
import slimeknights.tconstruct.library.traits.AbstractTrait
import slimeknights.tconstruct.library.utils.ToolHelper
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import thaumcraft.api.aura.AuraHelper
import kotlin.math.abs
import kotlin.math.ceil

class ArmorVisBarrier : PewterArmorTrait("Vis Barrier", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {

        val visInAir = AuraHelper.getVis(player.world, player.position)

        if (visInAir > DRAIN_AMOUNT && random.nextFloat() < DRAIN_CHANCE) {
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_ARMOR, player, 1)
            ArmorHelper.repairArmor(armor, REPAIR_AMOUNT, player)
            AuraHelper.drainVis(player.world, player.position, DRAIN_AMOUNT, false)
        }

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

    companion object {
        const val REPAIR_AMOUNT = 1
        const val DRAIN_CHANCE = 0.15
        const val DRAIN_AMOUNT = 1.8f
    }

}
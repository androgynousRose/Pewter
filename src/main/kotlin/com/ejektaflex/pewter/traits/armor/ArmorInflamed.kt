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
import kotlin.math.abs
import kotlin.math.ceil

class ArmorInflamed : PewterArmorTrait("Inflamed", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        Pewter.LOGGER.info("DOOT DOOT!")

        val healAmount = 2 + if (random.nextFloat() < 0.3) 1 else 0

        if (source.isFireDamage) {
            Pewter.LOGGER.info("Being on fire repaired your armor for $healAmount")
            ArmorHelper.repairArmor(armor, healAmount, player)
        }

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

}
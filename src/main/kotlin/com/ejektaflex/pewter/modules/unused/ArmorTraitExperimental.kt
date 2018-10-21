package com.ejektaflex.pewter.modules.unused

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.core.PewterLogger
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent

class ArmorTraitExperimental : PewterArmorTrait("CHANGEME", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        val healAmount = 2 + if (random.nextFloat() < 0.3) 1 else 0

        PewterLogger.info(source.isMagicDamage)
        PewterLogger.info(damage)
        evt

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

}
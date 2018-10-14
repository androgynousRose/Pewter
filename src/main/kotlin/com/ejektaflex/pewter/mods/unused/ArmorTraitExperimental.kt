package com.ejektaflex.pewter.mods.unused

import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.lib.InternalAPI
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent

class ArmorTraitExperimental : PewterArmorTrait("CHANGEME", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        val healAmount = 2 + if (random.nextFloat() < 0.3) 1 else 0

        InternalAPI.info(source.isMagicDamage)
        InternalAPI.info(damage)
        evt

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

}
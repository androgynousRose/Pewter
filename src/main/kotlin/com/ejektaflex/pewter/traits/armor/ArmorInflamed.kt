package com.ejektaflex.pewter.traits.armor

import c4.conarm.common.armor.utils.ArmorHelper
import com.ejektaflex.pewter.lib.traits.armor.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingDamageEvent

class ArmorInflamed : PewterArmorTrait("Inflamed", 0xFF2334) {

    override fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: Float, newDamage: Float, evt: LivingDamageEvent?): Float {
        val healAmount = 2 + if (random.nextFloat() < 0.3) 1 else 0

        if (source.isFireDamage) {
            ArmorHelper.repairArmor(armor, healAmount, player)
        }

        return super.onDamaged(armor, player, source, damage, newDamage, evt)
    }

}
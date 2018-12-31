package com.ejektaflex.pewter.modules.soot

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.SoundEvents
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingHurtEvent
import slimeknights.tconstruct.common.Sounds

class ArmorTraitSquelching(name: String) : PewterArmorTrait(name, 0xFF2334) {

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {
        evt?.let {
            if (evt.source.isFireDamage) {
                evt.amount /= 1.1f
                if (random.nextFloat() < 0.09f) {
                    Sounds.playSoundForAll(evt.entity, SoundEvents.BLOCK_LAVA_EXTINGUISH, 0.8f, 1f)
                    evt.entity.extinguish()
                }
            }
        }
        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

}
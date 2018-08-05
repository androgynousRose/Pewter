package com.ejektaflex.pewter.modifiers


import com.ejektaflex.pewter.Pewter
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect
import slimeknights.tconstruct.library.utils.TagUtil
import thaumcraft.api.aura.AuraHelper
import net.minecraft.init.MobEffects
import net.minecraft.potion.PotionEffect
import slimeknights.tconstruct.library.TinkerRegistry


class ModStick : PewterModTrait("Shtick", 0xffffff) {
    override val motto = "It's sticky!"
    override val description = "Slight increase to all stats."

    init {

        TinkerRegistry.addTrait(this)

        addAspects(
                ModifierAspect.SingleAspect(this)
        )

    }

    override fun onHit(tool: ItemStack?, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {


        val visInAir = AuraHelper.getVis(player.world, player.position)

        Pewter.LOGGER.info("OnHit was called")

        target.addPotionEffect(PotionEffect(MobEffects.LEVITATION, 2, 0))

        super.onHit(tool, player, target, damage + visInAir, isCritical)


    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound) {

        val data = TagUtil.getToolStats(rootCompound)
        data.durability += 1000 // Just a test for if it works

        data.attack += 0.2f
        data.speed += 0.05f

        TagUtil.setToolTag(rootCompound, data.get())
    }
}

package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ext.toItem
import com.ejektaflex.pewter.lib.mixins.TinkerNBTChanger
import com.ejektaflex.pewter.lib.modifiers.PewterModTrait
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.ModifierAspect
import slimeknights.tconstruct.library.utils.TagUtil
import net.minecraft.init.MobEffects
import net.minecraft.potion.PotionEffect


class ModStick : PewterModTrait("Shtick", 0xffff88), TinkerNBTChanger {

    init {
        addAspects(
                ModifierAspect.SingleAspect(this)
        )
    }

    override fun onHit(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, isCritical: Boolean) {
        val duration = getData(tool).level * 20
        target!!.addPotionEffect(PotionEffect(MobEffects.SLOWNESS, duration, 1))

        Pewter.LOGGER.info("OnHit was called")
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound) {
        val tool = TagUtil.getToolStats(rootCompound)

        tool.durability += 1000

        TagUtil.setToolTag(rootCompound, tool.get())

        super.applyEffect(rootCompound, modifierTag)
    }

    override fun configure() {
        addItem("thaumcraft:sanity_soap".toItem)
    }
}

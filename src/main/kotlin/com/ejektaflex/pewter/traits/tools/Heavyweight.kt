package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.PlayerEvent
import slimeknights.tconstruct.library.tinkering.Category
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.TinkerUtil


class Heavyweight : PewterToolTrait("heavyweight", 0x124026), TinkerNBTHelper {

    private val bonus = 1.1f
    private val loss = 0.95f

    override fun applyEffect(rootCompound: NBTTagCompound?, modifierTag: NBTTagCompound?) {
        super.applyEffect(rootCompound, modifierTag)

        // add the attack speed boost
        val data = TagUtil.getToolStats(rootCompound)

        data.attackSpeedMultiplier *= loss
        data.attack *= bonus

        TagUtil.setToolTag(rootCompound, data.get())


        if (TinkerUtil.hasCategory(rootCompound, Category.LAUNCHER)) {
            val launcherData = ProjectileLauncherNBT(TagUtil.getToolTag(rootCompound))
            launcherData.drawSpeed *= loss
            TagUtil.setToolTag(rootCompound, launcherData.get())
        }
    }

    override fun miningSpeed(tool: ItemStack, event: PlayerEvent.BreakSpeed) {
        // 10% bonus speed
        event.newSpeed = event.newSpeed * loss
    }
}
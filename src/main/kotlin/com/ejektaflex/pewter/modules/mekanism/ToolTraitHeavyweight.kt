package com.ejektaflex.pewter.modules.mekanism

import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.traits.PewterToolTrait
import com.ejektaflex.pewter.shared.methods.IBuffTradeoff
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.PlayerEvent
import slimeknights.tconstruct.library.tinkering.Category
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.TinkerUtil


class ToolTraitHeavyweight(modName: String) : PewterToolTrait(modName, 0x124026), TinkerNBTHelper, IBuffTradeoff {

    // Damage buff
    override val buffMult = 1.1f
    // Speed debuff
    override val debuffMult = 0.90f

    override fun applyEffect(rootCompound: NBTTagCompound?, modifierTag: NBTTagCompound?) {
        super.applyEffect(rootCompound, modifierTag)

        // add the attack speed boost
        val data = TagUtil.getToolStats(rootCompound)

        data.attackSpeedMultiplier *= debuffMult
        data.attack *= buffMult

        TagUtil.setToolTag(rootCompound, data.get())


        if (TinkerUtil.hasCategory(rootCompound, Category.LAUNCHER)) {
            val launcherData = ProjectileLauncherNBT(TagUtil.getToolTag(rootCompound))
            launcherData.drawSpeed *= debuffMult
            TagUtil.setToolTag(rootCompound, launcherData.get())
        }
    }

    override fun miningSpeed(tool: ItemStack, event: PlayerEvent.BreakSpeed) {
        // bonus speed
        event.newSpeed = event.newSpeed * buffMult
    }
}
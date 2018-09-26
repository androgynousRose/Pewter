package com.ejektaflex.pewter.mods.botania.tool


import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import net.minecraft.nbt.NBTTagCompound
import slimeknights.tconstruct.library.modifiers.IModifierDisplay
import slimeknights.tconstruct.library.modifiers.ModifierAspect
import slimeknights.tconstruct.library.tools.ToolNBT
import slimeknights.tconstruct.library.utils.HarvestLevels


class ToolModDragonstone(modName: String) : PewterToolModifier(modName, 0xED339A), TinkerNBTHelper, IModifierDisplay {

    init {
        addAspects(
                ModifierAspect.SingleAspect(this)
        )
    }

    override fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?) {

        val toolMod: ToolNBT.() -> Unit = {

            durability += 100
            attack += 0.05f

            if (harvestLevel < HarvestLevels.OBSIDIAN) {
                harvestLevel++
            }

            val numBotaniaMats = baseMaterials(rootCompound).count { it.representativeItem.comesFrom("botania") }.toDouble()

            durability = (durability * (1 + (numBotaniaMats / 10))).toInt()
            attack *= (1 + (numBotaniaMats / 35)).toFloat()

        }

        modifyToolStats(rootCompound, toolMod)
        super.applyEffect(rootCompound, modifierTag)
    }

    override fun configure() {
        safeAdd("botania:manaresource:9".toItemStack)
    }

}

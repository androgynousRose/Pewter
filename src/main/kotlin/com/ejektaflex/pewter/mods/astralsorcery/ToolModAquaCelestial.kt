package com.ejektaflex.pewter.mods.astralsorcery

import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.ext.*
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.shared.methods.IModAquaNight
import com.ejektaflex.pewter.shared.methods.IModChange
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import slimeknights.tconstruct.library.modifiers.IModifierDisplay
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import slimeknights.tconstruct.library.utils.ModifierTagHolder




class ToolModAquaCelestial(modName: String) : PewterToolModifier(modName, 0x2A93E8, 2, 25), TinkerNBTHelper, IModifierDisplay, IModChange<Float>, IModAquaNight {

    override val baseChange = 0f

    override fun modCost(item: ItemStack?): Float {
        val modData = item!!.getModifierIntNBT<ToolModAquaCelestial>()
        return modData.current / 250f
    }

    override fun configure() {
        safeAdd("astralsorcery:itemcraftingcomponent".toItemStack) // gemAquamarine
    }

    override fun onUpdate(tool: ItemStack?, world: World?, entity: Entity?, itemSlot: Int, isSelected: Boolean) {

        if (world?.isRemote != false) {
            return
        }

        (entity as? EntityPlayer)?.let {
            when (isRightSetting(entity)) {
                true -> {
                    if (!TagUtil.hasEnchantEffect(tool)) {
                        TagUtil.setEnchantEffect(tool, true)
                        TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_FIRE, entity, 2)
                    }
                }
                false -> {
                    if (TagUtil.hasEnchantEffect(tool)) {
                        // Don't disenchant a shocking tool that's charged
                        val charge = getShockingCharge(tool)
                        if (charge == null || charge < 100) {
                            TagUtil.setEnchantEffect(tool, false)
                        }
                    }
                }
            }
        }
    }

    // Checks to make sure we don't disenchant a charged Shocking tool (Electrum)
    private fun getShockingCharge(tool: ItemStack?): Float? {
        val modtag = ModifierTagHolder.getModifier(tool, "shocking")
        return try {
            modtag.tag?.get("charge")
        } catch (e: Exception) {
            null
        }
    }

    override fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, newDamage: Float, isCritical: Boolean): Float {
        var returnDamage = newDamage
        target?.let {
            if (isRightSetting(player!!)) {
                returnDamage *= 1f + modCost(tool)
                returnDamage *= 1f + when(player.posY) {
                    in 65..128 -> (player.posY.toFloat() - 64f) / 64f * elevationBonusMax
                    in 129..256 -> elevationBonusMax
                    else -> 0f
                }
            }
        }
        return returnDamage
    }

    override fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): MutableList<String> {
        val costLower = modCost(tool) * 100
        val costHigher = costLower * (1 + elevationBonusMax)
        return mutableListOf("Night Sky Tool Damage +${"%.1f".format(costLower)}-${"%.1f".format(costHigher)}%")
    }

    companion object {
        const val elevationBonusMax = 3f/4f
    }

}

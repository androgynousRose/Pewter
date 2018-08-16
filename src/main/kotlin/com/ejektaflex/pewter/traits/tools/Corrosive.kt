package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.ext.get
import com.ejektaflex.pewter.ext.set
import com.ejektaflex.pewter.traits.mixins.TinkerNBTChanger
import net.minecraft.client.resources.I18n
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.Tags
import slimeknights.tconstruct.shared.client.ParticleEffect
import slimeknights.tconstruct.tools.TinkerTools
import thebetweenlands.api.entity.IEntityBL
import thebetweenlands.common.config.BetweenlandsConfig
import kotlin.math.min
import slimeknights.tconstruct.library.utils.TinkerUtil
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import kotlin.math.max


class Corrosive : PewterTrait("Corrosive", 0x70FF3D), TinkerNBTChanger {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    fun tooltip(event: ItemTooltipEvent) {
        val tag = TagUtil.getTagSafe(event.itemStack)
        if (event.isCanceled || !TinkerUtil.hasTrait(tag, identifier))
            return

        val percent = TagUtil.getToolTag(event.itemStack).get<Int>(CORROSION_TAG).toDouble() / TagUtil.getOriginalToolStats(event.itemStack).durability
        event.toolTip.add(4, I18n.format("modifier.corrosive.tooltip", String.format("%.0f",percent * 100)+"%"))
    }

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity, itemSlot: Int, isSelected: Boolean) {
        if (entity !is EntityPlayer || entity.getEntityWorld().isRemote) {
            return
        }

        modifyToolStats(tool) { original, current ->
            if (!current.hasKey(CORROSION_TAG)) {
                current[CORROSION_TAG] = 0
            }
            // Add corrosion if we are in The Betweenlands
            if (entity.dimension == BetweenlandsConfig.WORLD_AND_DIMENSION.dimensionId && random.nextFloat() < CHANCE) {
                val newCorrosion = min(current.get<Int>(CORROSION_TAG) + 1, original.durability)
                current[CORROSION_TAG] = newCorrosion
                // Change attack value based on corrosion value
                val corrosionPercent = newCorrosion.toDouble() / original.durability.toDouble()
                val newAttack = original.attack * (1.0 - corrosionPercent)
                current[Tags.ATTACK] = max(original.attack.toDouble() * MIN_ATTACK_PERCENT, newAttack).toFloat()
            }
        }

    }

    override fun onRepair(tool: ItemStack?, amount: Int) {
        modifyToolStats(tool!!) { original, current ->
            current[CORROSION_TAG] = 0f
            current[Tags.ATTACK] = original.attack
        }
        super.onRepair(tool, amount)
    }

    override fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: Float, newDamage: Float, isCritical: Boolean): Float {
        var theNewDamage = damage
        // Bonus damage against BL mobs
        if (target is IEntityBL) {
            theNewDamage *= (1f + ATTACK_BONUS)
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_BLOOD, target, 2)
        }
        return theNewDamage
    }

    companion object {
        const val CORROSION_TAG = "BL_Corrosion"
        const val ATTACK_BONUS = 0.35f
        const val MIN_ATTACK_PERCENT = 0.35 // Will always do at least 35% of it's original damage
        const val CHANCE = 0.001f // Chance on a given tick to add Corrosion?
    }
}
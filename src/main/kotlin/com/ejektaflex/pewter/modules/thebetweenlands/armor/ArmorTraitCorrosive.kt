package com.ejektaflex.pewter.modules.thebetweenlands.armor

import c4.conarm.common.armor.utils.ArmorTagUtil
import com.ejektaflex.pewter.ext.get
import com.ejektaflex.pewter.ext.set
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.modules.thebetweenlands.tool.ToolTraitCorrosive
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraft.world.World
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.TinkerUtil
import thebetweenlands.api.entity.IEntityBL
import thebetweenlands.common.config.BetweenlandsConfig
import kotlin.math.max
import kotlin.math.min


class ArmorTraitCorrosive(name: String) : PewterArmorTrait(name, 0xFF2334), TinkerNBTHelper {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    fun tooltip(event: ItemTooltipEvent) {
        val tag = TagUtil.getTagSafe(event.itemStack)
        if (event.isCanceled || !TinkerUtil.hasTrait(tag, identifier))
            return

        val percent = ArmorTagUtil.getArmorStats(event.itemStack).get().get<Int>(ToolTraitCorrosive.CORROSION_TAG).toDouble() / ArmorTagUtil.getOriginalArmorStats(event.itemStack).durability

        val corrIndex = event.toolTip.asSequence().withIndex().find { "Corrosive" in it.value }
        corrIndex?.let {
            event.toolTip[corrIndex.index] += " (" + String.format("%.0f",percent * 100) + "% Corroded)"
        }

    }

    override fun onUpdate(armor: ItemStack, world: World, entity: Entity, itemSlot: Int, isSelected: Boolean) {
        if (entity !is EntityPlayer || entity.getEntityWorld().isRemote) {
            return
        }

        // Chance for armor corrosion will be 50% less because armor has on average less durability?
        if (entity.dimension == BetweenlandsConfig.WORLD_AND_DIMENSION.dimensionId && random.nextFloat() < ToolTraitCorrosive.CHANCE * 0.5f) {
            modifyArmorStats(armor) { original, current ->
                val newCorrosion = min(current.getFloat(ToolTraitCorrosive.CORROSION_TAG) + 1, original.durability.toFloat())
                val corrosionPercent = newCorrosion.toDouble() / original.durability.toDouble()
                val newDefense = original.defense * (1.0 - corrosionPercent)
                current[ArmorTagUtil.DEFENSE] = max(original.defense.toDouble() * MIN_DEFENSE_PERCENT, newDefense).toFloat()
                current[ToolTraitCorrosive.CORROSION_TAG] = if (current.hasKey(ToolTraitCorrosive.CORROSION_TAG)) {
                    newCorrosion
                } else {
                    0f
                }
            }
        }

    }

    override fun onRepair(armor: ItemStack?, amount: Int) {
        modifyArmorStats(armor!!) { original, current ->
            current[ArmorTagUtil.DEFENSE] = original.defense
            current[ToolTraitCorrosive.CORROSION_TAG] = 0f
        }
        super.onRepair(armor, amount)
    }

    override fun onHurt(armor: ItemStack?, player: EntityPlayer?, source: DamageSource?, damage: Float, newDamage: Float, evt: LivingHurtEvent?): Float {
        val chance = random.nextFloat()

        if (chance < 0.7) {
            if (source?.trueSource is IEntityBL) {
                return super.onHurt(armor, player, source, damage, newDamage * 0.75f, evt)
            }
        }
        return super.onHurt(armor, player, source, damage, newDamage, evt)
    }

    companion object {
        const val MIN_DEFENSE_PERCENT = 0.35
    }

}
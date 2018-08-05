package com.ejektaflex.pewter.traits.armor

import c4.conarm.common.armor.utils.ArmorTagUtil
import com.ejektaflex.pewter.ext.get
import com.ejektaflex.pewter.ext.set
import com.ejektaflex.pewter.traits.tools.Corrosive
import net.minecraft.client.resources.I18n
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
import kotlin.math.max
import kotlin.math.min


class ArmorCorrosive : PewterArmorTrait("Corrosive", 0xFF2334) {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    fun tooltip(event: ItemTooltipEvent) {
        val tag = TagUtil.getTagSafe(event.itemStack)
        if (event.isCanceled || !TinkerUtil.hasTrait(tag, identifier))
            return

        val percent = ArmorTagUtil.getArmorStats(event.itemStack).get().get<Int>(Corrosive.CORROSION_TAG).toDouble() / ArmorTagUtil.getOriginalArmorStats(event.itemStack).durability
        event.toolTip.add(1, I18n.format("modifier.corrosive.tooltip", String.format("%.0f",percent * 100)+"%"))
    }

    override fun onUpdate(armor: ItemStack, world: World, entity: Entity, itemSlot: Int, isSelected: Boolean) {
        if (entity !is EntityPlayer || entity.getEntityWorld().isRemote) {
            return
        }

        // Chance for armor corrosion will be 50% less because armor has on average less durability?
        if (random.nextFloat() < Corrosive.CHANCE * 0.5f) {
            val origArmorStats = ArmorTagUtil.getOriginalArmorStats(armor)
            val armorTag = ArmorTagUtil.getArmorStats(armor)
            val armorNBT = armorTag.get()

            if (!armorNBT.hasKey(Corrosive.CORROSION_TAG)) {
                armorNBT[Corrosive.CORROSION_TAG] = 0f
            }

            val newCorrosion = min(armorNBT.getFloat(Corrosive.CORROSION_TAG) + 1, origArmorStats.durability.toFloat())
            val corrosionPercent = newCorrosion.toDouble() / origArmorStats.durability.toDouble()
            val newDefense = origArmorStats.defense * (1.0 - corrosionPercent)

            armorTag.defense = max(origArmorStats.defense.toDouble() * MIN_DEFENSE_PERCENT, newDefense).toFloat()
            val toBeWritten = armorTag.get()
            toBeWritten[Corrosive.CORROSION_TAG] = newCorrosion

            TagUtil.setToolTag(armor, toBeWritten)
        }
    }

    override fun onRepair(armor: ItemStack?, amount: Int) {
        val theTag = ArmorTagUtil.getArmorStats(armor).get()
        theTag[Corrosive.CORROSION_TAG] = 0f
        theTag[ArmorTagUtil.DEFENSE] = ArmorTagUtil.getOriginalArmorStats(armor).defense
        TagUtil.setToolTag(armor, theTag)
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
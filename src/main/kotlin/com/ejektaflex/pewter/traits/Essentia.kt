package com.ejektaflex.pewter.traits

import com.ejektaflex.pewter.ext.plusAssign
import com.ejektaflex.pewter.ext.random
import net.minecraft.block.Block
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraftforge.event.world.BlockEvent
import thaumcraft.api.ThaumcraftApiHelper
import thaumcraft.api.aspects.AspectHelper
import thaumcraft.api.aura.AuraHelper

class Essentia : PewterTrait("Essentia", 0xFFFFFF) {
    override val motto = "Only the essentials!"
    override val description = "Killing enemies and breaking blocks has a chance of converting them to crystal essence, generating a tiny amount of flux."


    override fun blockHarvestDrops(tool: ItemStack, event: BlockEvent.HarvestDropsEvent) {
        if (random.nextFloat() <= chance) {
            event.harvester.inventory += getBlockCrystal(event.state.block)
            AuraHelper.polluteAura(event.world, event.pos, 1.0f, true)
        }
        super.blockHarvestDrops(tool, event)
    }

    override fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: Float, isCritical: Boolean) {
        if (target.health < damage) {
            if (random.nextFloat() <= chance) {
                target.entityDropItem(getEntityCrystal(target), 1f)
                AuraHelper.polluteAura(target.world, target.position, 1.0f, true)
            }
        }

        super.onHit(tool, player, target, damage, isCritical)
    }

    companion object {
        const val chance = 0.05f

        private fun getBlockCrystal(b: Block): ItemStack {
            val possibleAspects = AspectHelper.getObjectAspects(ItemStack(b))
            val pickedAspect = possibleAspects.getAspects().toList().random
            return ThaumcraftApiHelper.makeCrystal(pickedAspect)
        }

        private fun getEntityCrystal(e: EntityLivingBase): ItemStack {
            val possibleAspects = AspectHelper.getEntityAspects(e)
            val pickedAspect = possibleAspects.getAspects().toList().random
            return ThaumcraftApiHelper.makeCrystal(pickedAspect)
        }

    }

}
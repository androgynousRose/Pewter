package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.Pewter
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import slimeknights.tconstruct.library.utils.ToolHelper
import thaumcraft.api.aura.AuraHelper
import vazkii.botania.api.mana.ManaItemHandler
import kotlin.math.log10
import kotlin.math.min
import kotlin.math.pow


class ManaInfused : PewterTrait("manainfused", 0xE18EFF) {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {

        if (!world.isRemote && entity is EntityPlayer) {
            val manaToDraw = if (ToolHelper.isBroken(tool)) MANA_COST else UNBREAK_COST
            val manaGotten = ManaItemHandler.requestManaExactForTool(tool, entity, manaToDraw, true)

            // Randomness to make it regen 5x slower
            if (manaGotten && random.nextFloat() < 0.2f) {
                if (ToolHelper.isBroken(tool)) {
                    ToolHelper.unbreakTool(tool)
                }
                ToolHelper.healTool(tool, 1, entity)
            }
        }

        super.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

    companion object {
        const val MANA_COST = 80
        const val UNBREAK_COST = 160
    }

}
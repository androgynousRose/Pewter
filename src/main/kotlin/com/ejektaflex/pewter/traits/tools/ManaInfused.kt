package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.traits.tools.PewterTrait
import com.ejektaflex.pewter.traits.base.IModManaInfused
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ManaInfused : PewterTrait("Mana Infused", 0x005EE0), IModManaInfused {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        super<IModManaInfused>.onUpdate(tool, world, entity, itemSlot, isSelected)
        super<PewterTrait>.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

}
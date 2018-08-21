package com.ejektaflex.pewter.traits.tools

import com.ejektaflex.pewter.lib.traits.tools.PewterToolTrait
import com.ejektaflex.pewter.traits.base.IModManaInfused
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ManaInfused : PewterToolTrait("Mana Infused", 0x005EE0), IModManaInfused {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        super<IModManaInfused>.onUpdate(tool, world, entity, itemSlot, isSelected)
        super<PewterToolTrait>.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

}
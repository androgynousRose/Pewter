package com.ejektaflex.pewter.traits.armor

import com.ejektaflex.pewter.lib.traits.armor.PewterArmorTrait
import com.ejektaflex.pewter.traits.base.IModManaInfused
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ArmorManaInfused : PewterArmorTrait("Mana Infused", 0x005EE0), IModManaInfused {

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        super<IModManaInfused>.onUpdate(tool, world, entity, itemSlot, isSelected)
        super<PewterArmorTrait>.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

}
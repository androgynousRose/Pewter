package com.ejektaflex.pewter.mods.botania.armor

import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import com.ejektaflex.pewter.shared.methods.IArmorManaCost
import com.ejektaflex.pewter.shared.methods.IModManaInfused
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ArmorTraitManaInfused : PewterArmorTrait("Mana Infused", 0x005EE0), IModManaInfused, IArmorManaCost {

    override val manaCost = 50

    override fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        super<IModManaInfused>.onUpdate(tool, world, entity, itemSlot, isSelected)
        super<PewterArmorTrait>.onUpdate(tool, world, entity, itemSlot, isSelected)
    }

    override fun onToolDamage(tool: ItemStack, damage: Int, newDamage: Int, entity: EntityLivingBase?): Int {
        val newNewDamage = super<IModManaInfused>.onToolDamage(tool, damage, newDamage, entity)
        return super<PewterArmorTrait>.onToolDamage(tool, damage, newNewDamage, entity)
    }

}
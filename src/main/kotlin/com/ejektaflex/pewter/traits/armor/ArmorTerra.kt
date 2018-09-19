package com.ejektaflex.pewter.traits.armor

import c4.conarm.common.armor.utils.ArmorHelper
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.lib.mixins.ManaExchanger
import com.ejektaflex.pewter.lib.mixins.TinkerNBTHelper
import com.ejektaflex.pewter.api.core.traits.PewterArmorTrait
import net.minecraft.entity.Entity
import net.minecraft.world.World

class ArmorTerra : PewterArmorTrait("Terra", 0x83FF37), ManaExchanger, TinkerNBTHelper {

    override fun onUpdate(armor: ItemStack?, world: World?, entity: Entity?, itemSlot: Int, isSelected: Boolean) {
        if (entity == null || entity !is EntityPlayer || entity.getEntityWorld().isRemote) {
            return
        }

        if (entity.ticksExisted % 20 == 0) {
            val conArmor = entity.armorInventoryList.filter { ArmorHelper.isUnbrokenTinkersArmor(it) }

            // All four pieces of armor must be from ConArm
            if (conArmor.size < 4) {
                return
            }

            val terraArmor = conArmor.filter {
                PewterMaterials["terrasteel"]?.tinkMaterial in baseMaterials(it)
            }

            // All four pieces of armor must be made with Terrasteel
            if (terraArmor.size < 4) {
                return
            }

            // All cores must be made of terrasteel (method happens to always return core as first item)
            val allCoresTerrasteel = terraArmor.all { baseMaterialNames(it).first() == "terrasteel" }

            // Only execute for one of the items (the first one in the list of Terrasteel Armors
            if (allCoresTerrasteel && terraArmor.first() == armor) {
                entity.heal(0.165f)
            }

        }

        super.onUpdate(armor, world, entity, itemSlot, isSelected)

    }

}
package com.ejektaflex.pewter.api.core.traits

import c4.conarm.common.armor.utils.ArmorHelper
import c4.conarm.common.armor.utils.ArmorTagUtil
import c4.conarm.lib.armor.ArmorNBT
import c4.conarm.lib.traits.AbstractArmorTrait
import com.ejektaflex.pewter.api.PewterAPI
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import slimeknights.tconstruct.library.TinkerRegistry

/**
 * Extend this if you want to create a new Armor trait.
 */
@Suppress("LeakingThis")
open class PewterArmorTrait(val name: String, color: Int, identifier: String = name.toLowerCase().filter { it != ' ' })
    : AbstractArmorTrait(identifier, color), IPewterArmorTrait {
    init {
        if (Loader.isModLoaded("conarm")) {
            PewterAPI.log("Creating trait: $name (identifier: $identifier)")
            TinkerRegistry.addTrait(this)
            MinecraftForge.EVENT_BUS.register(this)
        }
    }

    private fun conArmorSet(entity: EntityPlayer): List<ItemStack> {
        return entity.armorInventoryList.filter { ArmorHelper.isUnbrokenTinkersArmor(it) }
    }

    fun armorSetStats(entity: EntityPlayer): List<ArmorNBT> {
        return conArmorSet(entity).map { ArmorTagUtil.getArmorStats(it) }
    }

    fun armorSetOriginalStats(entity: EntityPlayer): List<ArmorNBT> {
        return conArmorSet(entity).map { ArmorTagUtil.getOriginalArmorStats(it) }
    }

}
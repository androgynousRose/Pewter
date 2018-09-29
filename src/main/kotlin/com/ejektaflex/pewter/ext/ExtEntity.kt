package com.ejektaflex.pewter.ext

import c4.conarm.common.armor.utils.ArmorHelper
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumHand
import net.minecraft.world.biome.Biome
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.TinkerUtil


fun EntityLivingBase.isHoldingItemWithTrait(traitIdentifier: String): Boolean {
    return EnumHand.values().count { TinkerUtil.hasTrait(TagUtil.getTagSafe(getHeldItem(it)), traitIdentifier) } > 0
}

val EntityLivingBase.tinkersArmor: List<ItemStack>
    get() = armorInventoryList.filter { ArmorHelper.isUnbrokenTinkersArmor(it) }

fun EntityLivingBase.isWearingItemWithTrait(traitIdentifier: String): Boolean {
    return tinkersArmor.count { TinkerUtil.hasTrait(TagUtil.getTagSafe(it), traitIdentifier) } > 0
}

val EntityLivingBase.allArmor: List<Item>
    get() = armorInventoryList.map { it.item }

val EntityLivingBase.currentBiome: Biome
    get() = world.getBiome(position)

val EntityLivingBase.temperature: Float
    get() = currentBiome.getTemperature(position)
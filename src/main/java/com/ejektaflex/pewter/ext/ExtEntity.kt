package com.ejektaflex.pewter.ext

import net.minecraft.entity.EntityLivingBase
import net.minecraft.util.EnumHand
import slimeknights.tconstruct.library.utils.TagUtil
import slimeknights.tconstruct.library.utils.TinkerUtil


fun EntityLivingBase.isHoldingItemWithTrait(traitIdentifier: String): Boolean {
    return EnumHand.values().count { TinkerUtil.hasTrait(TagUtil.getTagSafe(getHeldItem(it)), traitIdentifier) } > 0
}
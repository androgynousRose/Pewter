package com.ejektaflex.pewter.modifiers.tools


import com.ejektaflex.pewter.lib.modifiers.GemToolModifier
import com.ejektaflex.pewter.modifiers.base.gems.IModMalachite
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack


class ModMalachite(modName: String) : GemToolModifier(modName, 0x079971), IModMalachite {

    override fun onToolHeal(tool: ItemStack?, amount: Int, newAmount: Int, entity: EntityLivingBase?): Int {
        return (newAmount * (1 + BONUS_PERCENT_REPAIRED)).toInt()
    }

    companion object {
        const val BONUS_PERCENT_REPAIRED = 0.2
    }

}


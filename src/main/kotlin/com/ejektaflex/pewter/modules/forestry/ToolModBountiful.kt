package com.ejektaflex.pewter.modules.forestry


import com.ejektaflex.pewter.api.core.modifiers.PewterToolModifier
import com.ejektaflex.pewter.core.PewterLogger
import com.ejektaflex.pewter.ext.getModifierIntNBT
import com.ejektaflex.pewter.ext.random
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.shared.methods.TinkerNBTHelper
import net.minecraft.block.BlockCrops
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.world.BlockEvent
import slimeknights.tconstruct.library.modifiers.IModifierDisplay
import slimeknights.tconstruct.library.utils.ToolHelper
import slimeknights.tconstruct.tools.tools.Kama
import slimeknights.tconstruct.tools.tools.Scythe

class ToolModBountiful(modName: String) : PewterToolModifier(modName, 0x58a6dd, 2, 75), TinkerNBTHelper, IModifierDisplay {

    private fun dropChance(item: ItemStack): Float {
        return item.getModifierIntNBT<ToolModBountiful>().current.toFloat() / 150 / 4 // Caps at 0.25
    }

    override fun blockHarvestDrops(tool: ItemStack, event: BlockEvent.HarvestDropsEvent) {
        if (!event.world.isRemote) {
            if (ToolHelper.isToolEffective2(tool, event.state) && (tool.item is Kama || tool.item is Scythe)) {
                event.state?.run {
                    if (event.state.block is BlockCrops && event.drops.isNotEmpty() && random.nextFloat() < dropChance(tool)) {
                        event.drops.add(event.drops.random.copy())
                    }
                }
            }
        }
    }

    // TODO: Limit appling only to Kama and Scythe?

    override fun getExtraInfo(tool: ItemStack, modifierTag: NBTTagCompound?): MutableList<String> {
        return mutableListOf("Bonus Harvest Drop +${"%.1f".format(dropChance(tool) * 100)}%")
    }

    override fun configure() {
        safeAdd("forestry:apatite".toItemStack)
    }
}

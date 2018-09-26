package com.ejektaflex.pewter.proxy

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.core.modifiers.IPewterModifier
import com.ejektaflex.pewter.content.*
import com.ejektaflex.pewter.ext.resource
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.registry.ForgeRegistries
import slimeknights.tconstruct.library.fluid.FluidMolten
import slimeknights.tconstruct.smeltery.block.BlockMolten


open class CommonProxy : IProxy {

    lateinit var fluid: FluidMolten
    lateinit var block: Block
    lateinit var item: Item

    override fun preInit(e: FMLPreInitializationEvent) {
        PewterContent.load()

        Pewter.LOGGER!!.info("Loaded ${PewterMaterials.content.size} dependencies.")

        for (mat in PewterMaterials) {
            mat.preInit(e)
        }

        makePewterFluid()
    }

    override fun init(e: FMLInitializationEvent) {
        for (mat in PewterMaterials) {
            mat.init(e)
        }
        configureModifiers()
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        for (mat in PewterMaterials) {
            mat.integrate()
        }
    }

    // Assign modifiers to items
    private fun configureModifiers() {
        for (mod in PewterModifiers) {
            if (mod is IPewterModifier) {
                mod.configure()
            }
        }
    }

    open fun makePewterFluid() {
        val name = "pewterfluid"
        fluid = FluidMolten(name, 0xffff00ff.toInt()).apply {
            unlocalizedName = "other"
            FluidRegistry.registerFluid(this)
        }

        block = BlockMolten(fluid).apply {
            setCreativeTab(null)
            unlocalizedName = Pewter.MODID + "." + name
            registryName = name.resource
            ForgeRegistries.BLOCKS.register(this)
        }

        item = ItemBlock(block).apply {
            registryName = name.resource
            ForgeRegistries.ITEMS.register(this)
        }

    }

}
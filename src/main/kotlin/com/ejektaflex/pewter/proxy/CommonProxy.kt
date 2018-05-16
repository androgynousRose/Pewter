package com.ejektaflex.pewter.proxy

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.ContentLoader
import com.ejektaflex.pewter.content.TinkerMaterials
import com.ejektaflex.pewter.content.TinkerModifiers
import com.ejektaflex.pewter.content.TinkerTraits
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

    //private var internalModifiers = TinkerModifiers.modifiers
    private var internalMaterials = TinkerMaterials.materials

    override fun preInit(e: FMLPreInitializationEvent) {
        val internalTraits = TinkerTraits.traits // Load traits
        ContentLoader.loadContent()
        makePewterFluid()
    }

    override fun init(e: FMLInitializationEvent) {
        Pewter.materials.forEach {
            it.associate()
            it.addMaterialTraits()
            it.represent()
        }
        addModifiers()
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        Pewter.materials.forEach {
            it.integrate()
        }
    }

    // Assign modifiers to items
    private fun addModifiers() {
        for (mod in TinkerModifiers.modifiers) {
            mod.key.apply(mod.value)
        }
    }

    open fun makePewterFluid() {
        val name = "pewterfluid"
        fluid = FluidMolten(name, 0xffff00ff.toInt()).apply {
            unlocalizedName = "unused"
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
package com.example.examplemod.proxy

import com.example.examplemod.Pewter
import com.example.examplemod.dsl.NewMaterial
import com.example.examplemod.ext.resource
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

        makePewterFluid()

        val mat1 = NewMaterial("hello", 0x888888) {
            locale("en_US" to "Test Material.")
            forge { true }
            craft { false }
            ingots("minecraft:apple")
            icon("minecraft:apple")
            head {
                durability { 100 }
                attack { 5 }
                speed { 1f }
            }
            handle {
                durability { 50 }
                mult { 1f }
            }
            extra {
                durability { 25 }
            }
            bow {
                accuracy { 0.5f }
                range { 1f }
                string { 1.1f }
                bonusDamage { 5f }
            }
            shaft {
                modifier { 1.1f }
                bonusAmmo { 5 }
            }
        }
        Pewter.materials.add(mat1)
    }

    override fun init(e: FMLInitializationEvent) {
        Pewter.materials.map { it.material }.forEach {
            //it.addMaterialTraits()
        }

    }

    override fun postInit(e: FMLPostInitializationEvent) {
        Pewter.materials.forEach {
            it.integrate()
        }
    }

    open fun makePewterFluid() {
        val name = "infinifluid"
        fluid = FluidMolten(name, 0xffff0000.toInt()).apply {
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
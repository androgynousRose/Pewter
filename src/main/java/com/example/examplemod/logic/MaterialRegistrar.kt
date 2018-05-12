package com.example.examplemod.logic

import com.example.examplemod.Pewter
import com.example.examplemod.dsl.ToolStats
import com.example.examplemod.ext.resource
import com.example.examplemod.ext.toItemStack
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.oredict.OreDictionary
import slimeknights.tconstruct.library.MaterialIntegration
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.fluid.FluidMolten
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.smeltery.block.BlockMolten
import java.awt.Color

class MaterialRegistrar(val tool: ToolStats) {

    private lateinit var integration: MaterialIntegration
    lateinit var material: Material
    private var ingot: ItemStack? = null
    var fluid: Fluid? = null
    lateinit var block: Block
    lateinit var fluidItem: ItemBlock

    init {
        addToOreDict()
        createMaterial()
        makeFluid()
        integrateMaterial()
        addMaterialStats()
    }

    // Register all associated items in the Ore Dictionary
    private fun addToOreDict() {
        for (type in tool.smelting.keys ) {
            tool.smelting[type]!!.forEach { itemString ->
                val item = itemString.toItemStack?.item
                // If that item exists, register it
                item?.let {
                    OreDictionary.registerOre(type + tool.name.capitalize(), it)
                }
            }
        }
    }

    private fun createMaterial() {
        material = TinkerRegistry.getMaterial(tool.name)
        if (material != Material.UNKNOWN) {
            println("Material already registered.")
        } else {
            material = Material(tool.name, Color.decode(tool.color).rgb)
        }
    }

    private fun makeFluid() {
        var name = tool.name.toLowerCase()
        fluid = FluidMolten(name, Color.decode(tool.color).rgb).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
        }
        FluidRegistry.registerFluid(fluid)

        // TODO Set fluid properties here

        //name = "molten_$name"
        // Create block
        block = BlockMolten(fluid).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
            registryName = name.resource
            setCreativeTab(null)
        }
        ForgeRegistries.BLOCKS.register(block)

        // Create item
        fluidItem = ItemBlock(block).apply {
            registryName = name.resource
            creativeTab = null
        }
        ForgeRegistries.ITEMS.register(fluidItem)

        // Bucket
        FluidRegistry.addBucketForFluid(fluid)

    }

    private fun integrateMaterial() {
        material.isCraftable = false
        material.isCastable = true

        val prefix = "ingot"
        val suffix = tool.name.capitalize()

        // Add ingot for item
        ingot.let {
            material.addItem(prefix + suffix, 1, Material.VALUE_Ingot)
            material.representativeItem = it
        }

        // Integrate
        integration = MaterialIntegration(prefix + suffix, material, fluid, suffix).apply {
            if (tool.madeInToolForge) { this.toolforge() }
            preInit()
        }
    }

    private fun addMaterialStats() {
        // Load all MatParts if none are specified
        val matsToLoad: Collection<ToolStats.MatPart> = if (tool.matParts.isEmpty()) {
            ToolStats.MatPart.values().toList()
        } else {
            tool.matParts
        }
        // Register stats for each MatPart
        matsToLoad.forEach {
            tool.registerStats(material, it)
        }
    }

    fun integrate() {
        integration.integrate()
    }
}
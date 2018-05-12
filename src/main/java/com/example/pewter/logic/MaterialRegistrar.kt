package com.example.pewter.logic

import com.example.pewter.Pewter
import com.example.pewter.ext.resource
import com.example.pewter.ext.toItemStack
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

class MaterialRegistrar(val stats: MaterialStats) {

    private lateinit var integration: MaterialIntegration
    lateinit var tinkMaterial: Material
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
        for (type in stats.smelting.keys ) {
            stats.smelting[type]!!.forEach { itemString ->
                val item = itemString.toItemStack?.item
                // If that item exists, register it
                item?.let {
                    OreDictionary.registerOre(type + stats.name.capitalize(), it)
                }
            }
        }
    }

    private fun createMaterial() {
        tinkMaterial = TinkerRegistry.getMaterial(stats.name)
        if (tinkMaterial != Material.UNKNOWN) {
            println("Material already registered.")
        } else {
            tinkMaterial = Material(stats.name, Color.decode(stats.color).rgb)
        }
    }

    private fun makeFluid() {
        val name = stats.name.toLowerCase()
        fluid = FluidMolten(name, Color.decode(stats.color).rgb).apply {
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
        tinkMaterial.isCraftable = false
        tinkMaterial.isCastable = true

        val prefix = "ingot"
        val suffix = stats.name.capitalize()

        // Add ingot for item
        ingot.let {
            tinkMaterial.addItem(prefix + suffix, 1, Material.VALUE_Ingot)
            tinkMaterial.representativeItem = it
        }

        // Integrate
        integration = MaterialIntegration(prefix + suffix, tinkMaterial, fluid, suffix).apply {
            if (stats.madeInToolForge) { this.toolforge() }
            preInit()
        }
    }

    private fun addMaterialStats() {
        // Load all MatParts if none are specified
        val matsToLoad: Collection<MaterialStats.MatPart> = if (stats.matParts.isEmpty()) {
            MaterialStats.MatPart.values().toList()
        } else {
            stats.matParts
        }
        // Register stats for each MatPart
        matsToLoad.forEach {
            stats.registerStats(tinkMaterial, it)
        }
    }

    fun integrate() {
        integration.integrate()
    }
}
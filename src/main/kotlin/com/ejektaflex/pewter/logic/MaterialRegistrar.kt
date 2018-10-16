package com.ejektaflex.pewter.logic

import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData.MatPart
import com.ejektaflex.pewter.api.core.materials.stats.SmeltingStats
import com.ejektaflex.pewter.lib.PewterInfo
import com.ejektaflex.pewter.lib.PewterLogger
import com.ejektaflex.pewter.logic.crafting.ItemSmelteryHandler
import com.ejektaflex.pewter.logic.crafting.TagSmelteryHandler
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.registry.ForgeRegistries
import slimeknights.tconstruct.library.MaterialIntegration
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.fluid.FluidMolten
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.library.traits.ITrait
import slimeknights.tconstruct.smeltery.block.BlockMolten
import java.awt.Color

class MaterialRegistrar(val data: MaterialData) : IProxy {

    private lateinit var integration: MaterialIntegration
    lateinit var tinkMaterial: Material
    var fluid: Fluid? = null
    var block: Block? = null
    var fluidItem: ItemBlock? = null
    val tagHandler = TagSmelteryHandler(this)
    val itemHandler = ItemSmelteryHandler(this)

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    override fun preInit(e: FMLPreInitializationEvent) {
        transformSuffixes()
        createMaterial()
        makeFluid()
        preIntegrateMaterial()
        addMaterialStats()
    }

    override fun init(e: FMLInitializationEvent) {
        itemHandler.associateAll()
        tagHandler.associateAll()
        addMaterialTraits()
        represent()
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        integrateMaterial()
        itemHandler.integrateAll()
        tagHandler.integrateAll()
    }

    private fun transformSuffixes() {
        for (suffix in data.oreDictSuffixes) {
            SmeltingStats.SmeltingType.values().forEach { smeltingType ->
                smeltingType.of(data.smeltingTags).add("${smeltingType.name.toLowerCase()}$suffix")
            }
        }
    }

    private fun represent() {
        // Material will be represented in Table of Contents by first ingot we get from OreDict tags or items
        val itemToRepresentWith = tagHandler.representativeItem() ?: itemHandler.representativeItem()

        if (itemToRepresentWith != null) {
            tinkMaterial.representativeItem = itemToRepresentWith
            PewterLogger.verbose("${data.name} is being represented by '${tinkMaterial.representativeItem.displayName}'")
        } else {
            PewterLogger.warn("${data.name} is not being represented by anything, no valid items were found.")
        }

    }

    private fun addMaterialTraits() {
        var numSpecTraits = 0

        // Specific Traits
        for ((specificPartName, traitNames) in data.specificTraits) {
            try {
                val matPart = MatPart.valueOf(specificPartName)
                for (traitName in traitNames) {
                    val specTrait = addTrait(traitName, matPart)
                    if (specTrait) numSpecTraits++
                }
            } catch (e: Exception) {
                PewterLogger.fatal("I don't think a part exists for the part identifier $specificPartName")
                e.printStackTrace()
            }
        }
        PewterLogger.verbose("Loaded $numSpecTraits specific traits for '${tinkMaterial.identifier}'.")
    }

    private fun addTrait(name: String, matPart: MatPart? = null): Boolean {
        val imod = TinkerRegistry.getModifier(name)
        return if (imod != null && imod is ITrait) {
            // If no specific part given, given to all material mat parts
            if (matPart == null) {
                tinkMaterial.addTrait(imod)
            } else {
                tinkMaterial.addTrait(imod, matPart.dependency)
            }
            true
        } else {
            PewterLogger.warn("Trait '$name' does not exist!")
            false
        }
    }

    private fun createMaterial() {
        tinkMaterial = TinkerRegistry.getMaterial(data.name)
        if (tinkMaterial != Material.UNKNOWN) {
            PewterLogger.verbose("Material already registered. (${data.name})")
        } else {
            tinkMaterial = Material(data.name, Color.decode(data.color).rgb)
        }
    }

    private fun makeFluid() {

        if (data.craftable) { // If not craftable, must be castable and need a fluids
            return
        }

        if (data.fluidNames != null) {
            PewterLogger.verbose("Instead of making a fluids for material ${data.name}, we are going to try to load one of these: ${data.fluidNames}")
            PewterLogger.verbose("All fluids: ${FluidRegistry.getBucketFluids().map { it.unlocalizedName }}")

            val fluidToUse = data.fluidNames!!.map { FluidRegistry.getFluid(it) }.firstOrNull()
            if (fluidToUse != null) {
                fluid = fluidToUse
                return
            } else {
                throw Exception("No fluids was found matching these names: ${data.fluidNames}.")
            }
        }

        PewterLogger.verbose("Making fluids for material ${data.name}")

        var name = data.name.toLowerCase()
        fluid = FluidMolten(name, Color.decode(data.color).rgb).apply {
            unlocalizedName = "${PewterInfo.MODID}.$name"
            viscosity = data.fluid.viscosity
            density = data.fluid.density
            temperature = data.fluid.temperature
            luminosity = data.fluid.luminosity
        }
        FluidRegistry.registerFluid(fluid)


        name = "molten_$name"
        // Create block
        block = BlockMolten(fluid).apply {
            unlocalizedName = "${PewterInfo.MODID}.$name"
            registryName = name.resource
        }
        //block.setCreativeTab(null)

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


    private fun preIntegrateMaterial() {
        tinkMaterial.isCraftable = data.craftable
        tinkMaterial.isCastable = !data.craftable

        // Integrate
        integration = MaterialIntegration(tinkMaterial, fluid).apply {
            if (data.madeInToolForge) { this.toolforge() }
            preInit()
        }
    }

    private fun integrateMaterial() {
        integration.integrate()
        fluid?.let {
            for (suffix in data.oreDictSuffixes) {
                //PewterLogger.verbose("Integrating '${data.name}' with suffix: '$suffix'")
                //TinkerSmeltery.registerOredictMeltingCasting(fluid, suffix)
            }
        }
    }

    private fun addMaterialStats() {
        // Load all MatParts if none are specified
        val matsToLoad: Collection<MaterialData.MatPart> = if (data.matParts.isEmpty()) {
            MaterialData.MatPart.values().toList()
        } else {
            data.matParts
        }
        // Register data for each MatPart
        matsToLoad.forEach {
            data.registerStats(tinkMaterial, it)
        }
    }

    fun integrate() {
        integration.integrate()
    }
}
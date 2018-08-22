package com.ejektaflex.pewter.logic

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.logic.stats.MaterialData
import com.ejektaflex.pewter.logic.stats.MaterialData.MatPart
import com.ejektaflex.pewter.logic.stats.SmeltingStats
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.oredict.OreDictionary
import slimeknights.mantle.util.RecipeMatch
import slimeknights.tconstruct.library.MaterialIntegration
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.fluid.FluidMolten
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.library.smeltery.MeltingRecipe
import slimeknights.tconstruct.library.traits.ITrait
import slimeknights.tconstruct.smeltery.block.BlockMolten
import java.awt.Color

class MaterialRegistrar(val data: MaterialData) {

    private lateinit var integration: MaterialIntegration
    lateinit var tinkMaterial: Material
    var fluid: Fluid? = null
    var block: Block? = null
    var fluidItem: ItemBlock? = null

    init {
        createMaterial()
        makeFluid()
        integrateMaterial()
        addMaterialStats()
    }

    // Register all associated items in the Ore Dictionary
    fun associate() {

        // Register for melting on a casting table
        //TinkerSmeltery.registerToolpartMeltingCasting(tinkMaterial)

        for (smeltingSize in SmeltingStats.SmeltingType.values() ) {
            data.smelting[smeltingSize]!!.forEach { itemString ->
                val itemStack = itemString.toItemStack
                val tag = smeltingSize.name.toLowerCase() + data.name.capitalize()
                // If that item exists, configure it
                if (itemStack != null) {
                    Pewter.LOGGER.info("Registering item $itemStack with ore dictionary tag $tag")
                    OreDictionary.registerOre(tag, itemStack) // This may not be working?
                    tinkMaterial.addItem(itemStack, 1, smeltingSize.amount)

                    if (fluid != null && data.createMeltingRecipes) {
                        //*
                        val meltingRecipe = MeltingRecipe(
                                RecipeMatch.of(itemStack, smeltingSize.amount),
                                fluid,
                                data.meltingTemperature
                        )
                        TinkerRegistry.registerMelting(meltingRecipe)
                        //*/
                    }
                } else {
                    Pewter.LOGGER.warn("Could not associate $itemString with material named '${data.name}'! Reason is because the item doesn't exist.")
                }
            }
        }
    }

    fun represent() {
        // Material will be represented in Table of Contents by first ingot we get
        //val itemToRepresentWith = data.smelting["ingot"]?.get(0)?.toItemStack
        val itemToRepresentWith = data.smelting.allItems().first().toItemStack

        itemToRepresentWith?.let {
            Pewter.LOGGER.info("Representing ${data.name} with a $it")
            tinkMaterial.representativeItem = it
            Pewter.LOGGER.info("${data.name} is being represented by a ${tinkMaterial.representativeItem}")
        }
    }


    fun addMaterialTraits() {
        var numSpecTraits = 0
        // Default Trait

        // Specific Traits
        for ((specificPartName, traitNames) in data.specificTraits) {
            try {
                val matPart = MatPart.valueOf(specificPartName)
                for (traitName in traitNames) {
                    val specTrait = addTrait(traitName, matPart)
                    if (specTrait) numSpecTraits++
                }
            } catch (e: Exception) {
                Pewter.LOGGER.error("I don't think a part exists for the part name $specificPartName")
                e.printStackTrace()
            }
        }
        Pewter.LOGGER.info("Loaded $numSpecTraits specific traits for $tinkMaterial.")
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
            Pewter.LOGGER.warn("Trait '$name' does not exist!")
            false
        }
    }

    private fun createMaterial() {
        tinkMaterial = TinkerRegistry.getMaterial(data.name)
        if (tinkMaterial != Material.UNKNOWN) {
            println("Material already registered.")
        } else {
            tinkMaterial = Material(data.name, Color.decode(data.color).rgb)
        }
    }

    private fun makeFluid() {

        if (data.craftable) { // If not craftable, must be castable and need a fluids
            return
        }

        if (data.fluidNames != null) {
            Pewter.LOGGER.info("Instead of making a fluids for material ${data.name}, we are going to try to load one of these: ${data.fluidNames}")
            Pewter.LOGGER.info("All fluids: ${FluidRegistry.getBucketFluids().map { it.unlocalizedName }}")

            val fluidToUse = data.fluidNames!!.map { FluidRegistry.getFluid(it) }.firstOrNull()
            if (fluidToUse != null) {
                fluid = fluidToUse
                return
            } else {
                throw Exception("No fluids was found matching these names: ${data.fluidNames}. " +
                        "These were the fluids that WERE found: ${FluidRegistry.getBucketFluids().map { it.name }}")
            }
        }

        Pewter.LOGGER.info("Making fluids for material ${data.name}")

        var name = data.name.toLowerCase()
        fluid = FluidMolten(name, Color.decode(data.color).rgb).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
            viscosity = data.fluid["viscosity"] ?: 0
            density = data.fluid["density"] ?: 0
            temperature = data.fluid["temperature"] ?: 0
            luminosity = data.fluid["luminosity"] ?: 0
        }
        FluidRegistry.registerFluid(fluid)


        name = "molten_$name"
        // Create block
        block = BlockMolten(fluid).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
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



    private fun integrateMaterial() {
        tinkMaterial.isCraftable = data.craftable
        tinkMaterial.isCastable = !data.craftable

        val prefix = "ingot"
        val suffix = data.name.capitalize()

        // Integrate
        integration = MaterialIntegration(prefix + suffix, tinkMaterial, fluid, null).apply {
            if (data.madeInToolForge) { this.toolforge() }
            preInit()
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
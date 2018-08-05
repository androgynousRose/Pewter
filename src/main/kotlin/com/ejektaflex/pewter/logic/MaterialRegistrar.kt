package com.ejektaflex.pewter.logic

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.ext.toItemStack
import com.ejektaflex.pewter.logic.stats.MaterialStats
import com.ejektaflex.pewter.logic.stats.MaterialStats.MatPart
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
import slimeknights.tconstruct.smeltery.TinkerSmeltery
import slimeknights.tconstruct.smeltery.block.BlockMolten
import java.awt.Color

class MaterialRegistrar(val stats: MaterialStats) {

    private lateinit var integration: MaterialIntegration
    lateinit var tinkMaterial: Material
    var fluid: Fluid? = null
    lateinit var block: Block
    lateinit var fluidItem: ItemBlock

    init {
        createMaterial()
        makeFluid()
        integrateMaterial()
        addMaterialStats()
    }

    // Register all associated items in the Ore Dictionary
    fun associate() {

        val strMap = mapOf(
                "ingot" to Material.VALUE_Ingot,
                "nugget" to Material.VALUE_Nugget,
                "block" to Material.VALUE_Block,
                "ore" to Material.VALUE_Ore()
        )

        // Register for melting on a casting table
        //TinkerSmeltery.registerToolpartMeltingCasting(tinkMaterial)

        for (type in stats.smelting.keys ) {
            stats.smelting[type]!!.forEach { itemString ->
                val itemStack = itemString.toItemStack
                val tag = type + stats.name.capitalize()
                // If that item exists, register it
                if (itemStack != null) {
                    Pewter.LOGGER.info("Registering item $itemStack with ore dictionary tag $tag")
                    OreDictionary.registerOre(tag, itemStack) // This may not be working?
                    tinkMaterial.addItem(itemStack, 1, strMap[type]!!)

                    // Register melting the item into it's fluid form (if there is a fluid)
                    fluid?.let {
                        val meltingRecipe = MeltingRecipe(
                                RecipeMatch.of(itemStack, strMap[type]!!),
                                fluid,
                                stats.meltingTemperature
                        )
                        TinkerRegistry.registerMelting(meltingRecipe)
                    }
                } else {
                    Pewter.LOGGER.warn("Could not associate $itemString with material named '${stats.name}'! Reason is because the item doesn't exist.")
                }
            }
        }
    }

    fun represent() {
        // Material will be represented in Table of Contents by first ingot we get
        val itemToRepresentWith = stats.smelting["ingot"]?.get(0)?.toItemStack

        itemToRepresentWith?.let {
            tinkMaterial.addItem(it, 1, Material.VALUE_Ingot)
            Pewter.LOGGER.info("Representing ${stats.name} with a $it")
            tinkMaterial.representativeItem = it
            Pewter.LOGGER.info("${stats.name} is being represented by a ${tinkMaterial.representativeItem}")
        }
    }


    fun addMaterialTraits() {
        var numSpecTraits = 0
        // Default Trait

        // Specific Traits
        for ((specificPartName, traitNames) in stats.specificTraits) {
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
        tinkMaterial = TinkerRegistry.getMaterial(stats.name)
        if (tinkMaterial != Material.UNKNOWN) {
            println("Material already registered.")
        } else {
            tinkMaterial = Material(stats.name, Color.decode(stats.color).rgb)
        }
    }

    private fun makeFluid() {

        if (stats.craftable) { // If not craftable, must be castable and need a fluid
            return
        }

        Pewter.LOGGER.info("Making fluid for material ${stats.name}")

        var name = stats.name.toLowerCase()
        fluid = FluidMolten(name, Color.decode(stats.color).rgb).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
            viscosity = stats.fluid["viscosity"] ?: 0
            density = stats.fluid["density"] ?: 0
            temperature = stats.fluid["temperature"] ?: 0
            luminosity = stats.fluid["luminosity"] ?: 0
        }
        FluidRegistry.registerFluid(fluid)


        name = "molten_$name"
        // Create block
        block = BlockMolten(fluid)
        block.unlocalizedName = "${Pewter.MODID}.$name"
        block.registryName = name.resource
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
        tinkMaterial.isCraftable = stats.craftable
        tinkMaterial.isCastable = !stats.craftable

        val prefix = "ingot"
        val suffix = stats.name.capitalize()

        // Add ingot for item
        /*
        ingot.let {
            tinkMaterial.addItem(prefix + suffix, 1, Material.VALUE_Ingot)
            tinkMaterial.representativeItem = it
        }
        */

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
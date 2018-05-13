package com.ejektaflex.pewter.logic

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.ext.toItemStack
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
import slimeknights.tconstruct.library.traits.ITrait
import slimeknights.tconstruct.smeltery.block.BlockMolten
import com.ejektaflex.pewter.logic.MaterialStats.MatPart
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

    fun addMaterialTraits() {
        var numGenTraits = 0
        var numSpecTraits = 0
        // Default Trait
        val defTrait = addTrait(stats.defaultTrait)
        if (defTrait) numGenTraits++
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
        Pewter.LOGGER.info("Loaded $numGenTraits default traits.")
        Pewter.LOGGER.info("Loaded $numSpecTraits specific traits.")
    }

    private fun addTrait(name: String, matPart: MatPart? = null): Boolean {
        val imod = TinkerRegistry.getModifier(name)
        return if (imod != null && imod is ITrait) {
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
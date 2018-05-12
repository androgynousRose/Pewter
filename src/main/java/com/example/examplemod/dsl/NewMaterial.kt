package com.example.examplemod.dsl

import com.example.examplemod.Pewter
import com.example.examplemod.ext.resource
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.Fluid
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import slimeknights.tconstruct.library.MaterialIntegration
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.fluid.FluidMolten
import slimeknights.tconstruct.library.materials.Material
import slimeknights.tconstruct.smeltery.block.BlockMolten

class NewMaterial(initFunc: NewMaterial.() -> Unit) : DSL<NewMaterial>() {

    lateinit var material: Material
    private lateinit var matFluid: Fluid
    private lateinit var matBlock: Block
    private lateinit var fluidItem: ItemBlock
    private lateinit var matIngot: ItemStack
    private lateinit var integration: MaterialIntegration
    val tool = ToolStats()

    init {
        println("Going to add values to $tool")
        apply(initFunc)
        println("Creating material for $tool...")
        createMaterial()
        println("Making fluids for material $material...")
        makeFluid()
        println("Integrating material $material...")
        integrateMaterial()
        println("Adding material stats to $material")
        addMaterialStats()
        println("Added material stats to $tool")
    }

    private fun createMaterial() {
        material = TinkerRegistry.getMaterial(tool.name)
        if (material != Material.UNKNOWN) {
            println("Material already registered.")
        } else {
            material = Material(tool.name, 0x888888)
        }
    }

    private fun makeFluid() {
        var name = tool.name.toLowerCase()
        matFluid = FluidMolten(name, 0x888888)
        matFluid.unlocalizedName = "${Pewter.MODID}:$name"
        FluidRegistry.registerFluid(matFluid)

        // TODO Set fluid properties here

        name = "molten_$name"

        // Create block
        matBlock = BlockMolten(matFluid).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
            registryName = name.resource
            setCreativeTab(null)
        }
        ForgeRegistries.BLOCKS.register(matBlock)

        // Create item
        fluidItem = ItemBlock(matBlock).apply {
            registryName = name.resource
            creativeTab = null
        }
        ForgeRegistries.ITEMS.register(fluidItem)

        // Bucket
        FluidRegistry.addBucketForFluid(matFluid)

    }

    private fun integrateMaterial() {
        material.isCraftable = false
        material.isCastable = true

        val prefix = "ingot"
        val suffix = tool.name.capitalize()

        // Add ingot for item
        matIngot.let {
            material.addItem(prefix + suffix, 1, Material.VALUE_Ingot)
            material.representativeItem = it

        }

        // Integrate
        integration = MaterialIntegration(prefix + suffix, material, matFluid, suffix).apply {
            if (tool.madeInToolForge) { this.toolforge() }
            preInit()
        }
    }

    private fun addMaterialStats() {
        ToolStats.MatPart.values().forEach {
            println("Adding Stats For: $it")
            tool.registerStats(material, it)
        }
    }

    fun integrate() {
        integration.integrate()
    }

    @DslMarker
    annotation class TopLevelToolDSL

    @DslMarker
    annotation class NestedDSL

    @TopLevelToolDSL
    fun name(func: () -> String) {
        tool.name = func()
    }

    @TopLevelToolDSL
    fun forge(func: () -> Boolean) {
        tool.madeInToolForge = func()
    }

    @TopLevelToolDSL
    fun ingot(func: () -> ItemStack) {
        matIngot = func()
    }

    @TopLevelToolDSL
    fun head(func: HeadCreator.() -> Unit) {
        HeadCreator().apply(func)
    }

    inner class HeadCreator : DSL<HeadCreator>() {


        @NestedDSL
        fun durability(func: () -> Int) {
            tool.durability = func()
        }

        @NestedDSL
        fun attack(func: () -> Int) {
            tool.attack = func()
        }

        @NestedDSL
        fun speed(func: () -> Int) {
            tool.matSpeed = func()
        }
    }

    @TopLevelToolDSL
    fun handle(func: HandleCreator.() -> Unit) {
        HandleCreator().apply(func)
    }

    inner class HandleCreator : DSL<HandleCreator>() {
        @NestedDSL
        fun durability(func: () -> Int) {
            tool.handleDurability = func()
        }

        @NestedDSL
        fun mult(func: () -> Float) {
            tool.handleMult = func()
        }
    }

    @TopLevelToolDSL
    fun extra(func: ExtraCreator.() -> Unit) {
        ExtraCreator().apply(func)
    }

    inner class ExtraCreator : DSL<ExtraCreator>() {
        @NestedDSL
        fun durability(func: () -> Int) {
            tool.extraDurability = func()
        }
    }

    @TopLevelToolDSL
    fun bow(func: BowCreator.() -> Unit) {
        BowCreator().apply(func)
    }

    inner class BowCreator : DSL<BowCreator>() {
        @NestedDSL
        fun accuracy(func: () -> Float) {
            tool.bowAccuracy = func()
        }

        @NestedDSL
        fun range(func: () -> Int) {
            tool.bowRange = func()
        }

        @NestedDSL
        fun string(func: () -> Float) {
            tool.stringModifier = func()
        }
    }

    @TopLevelToolDSL
    fun shaft(func: ShaftCreator.() -> Unit) {
        ShaftCreator().apply(func)
    }

    inner class ShaftCreator : DSL<ShaftCreator>() {
        @NestedDSL
        fun modifier(func: () -> Float) {
            tool.arrowShaftModifier = func()
        }

        @NestedDSL
        fun bonusAmmo(func: () -> Int) {
            tool.arrowShaftBonusAmmo = func()
        }
    }


}
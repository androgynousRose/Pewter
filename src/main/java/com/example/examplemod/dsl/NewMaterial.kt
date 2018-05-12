package com.example.examplemod.dsl

import com.example.examplemod.Pewter
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

open class NewMaterial(initName: String, initColor: String, initFunc: NewMaterial.() -> Unit) : DSL<NewMaterial>() {

    lateinit var material: Material
    var matFluid: Fluid? = null
    lateinit var matBlock: Block
    lateinit var fluidItem: ItemBlock
    private var matIngot: ItemStack? = null
    private lateinit var integration: MaterialIntegration

    var tool = ToolStats()

    constructor(toolData: ToolStats) : this(toolData.name, toolData.color, {}) {
       tool = toolData
    }

    init {
        tool.color = initColor
        tool.name = initName
        apply(initFunc)
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
        matFluid = FluidMolten(name, Color.decode(tool.color).rgb).apply {
            unlocalizedName = "${Pewter.MODID}.$name"
        }
        FluidRegistry.registerFluid(matFluid)

        // TODO Set fluid properties here

        //name = "molten_$name"
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

    @DslMarker
    annotation class TopLevelToolDSL

    @DslMarker
    annotation class NestedDSL

    @TopLevelToolDSL
    fun locale(vararg pairs: Pair<String, String>) {
        tool.nameLocales = pairs.toMap().toMutableMap()
    }

    @TopLevelToolDSL
    fun parts(vararg someParts: ToolStats.MatPart) {
        someParts.forEach { tool.matParts.add(it) }
    }

    fun ingots(vararg ing: String) {
        // Add all ingots to map
        tool.smelting["ingot"]!!.addAll(ing)
        // Set icon to first ingot if no icon exists yet
        if (matIngot == null && tool.smelting["ingot"]!!.isNotEmpty()) {
            val foundName = tool.smelting["ingot"]!!.first()
            val found = foundName.toItemStack
            if (found != null) {
                matIngot = found
            } else {
                throw Exception("This item does NOT exist at this time!: $foundName")
            }
        }
    }

    @TopLevelToolDSL
    fun forge(func: () -> Boolean) {
        tool.madeInToolForge = func()
    }

    @TopLevelToolDSL
    fun craft(func: () -> Boolean) {
        tool.craftable = func()
    }


    @TopLevelToolDSL
    fun icon(s: String) {
        matIngot = s.toItemStack!!
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
            tool.toolAttackDamage = func()
        }

        @NestedDSL
        fun speed(func: () -> Float) {
            tool.toolSpeed = func()
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
        fun bonusDamage(func: () -> Float) {
            tool.bowBonusDamage = func()
        }

        @NestedDSL
        fun range(func: () -> Float) {
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
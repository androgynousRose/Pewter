package com.example.pewter.proxy

import com.example.pewter.Pewter
import com.example.pewter.logic.MaterialStats
import com.example.pewter.ext.resource
import com.example.pewter.logic.ExampleMaterial
import com.example.pewter.logic.MaterialRegistrar
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
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
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files


open class CommonProxy : IProxy {

    lateinit var fluid: FluidMolten
    lateinit var block: Block
    lateinit var item: Item

    override fun preInit(e: FMLPreInitializationEvent) {
        loadMaterialData()
        makePewterFluid()
        if (Pewter.materials.size == 0) {
            saveExampleMaterial()
        }
    }

    private fun saveExampleMaterial() {
        val gson = GsonBuilder().setPrettyPrinting().create()
        try {
            FileWriter("${Pewter.CONFIGDIR}\\_example.json").use { writer ->
                gson.toJson(ExampleMaterial().tool, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun loadMaterialData() {
        // Load materials as MaterialStats and then register them all
        val loadedMaterials = loadMaterialFiles(Pewter.CONFIGDIR).map {
            MaterialRegistrar(it)
        }
        Pewter.LOGGER.info("Loaded ${loadedMaterials.size} materials.")
        Pewter.materials.addAll(loadedMaterials)
    }

    private fun loadMaterialFiles(dir: File): MutableList<MaterialStats> {

        val statList = mutableListOf<MaterialStats>()
        val gson = Gson()

        for (file in dir.listFiles()) {
            when {
                file.isDirectory -> {
                    for (stat in loadMaterialFiles(file)) {
                        statList.add(stat)
                    }
                }
                file.name.endsWith(".json") && !file.name.startsWith("_") -> {
                    Pewter.LOGGER.info("Attempting to parse: ${file.name}")
                    val parsedStat: Any? = try {
                        val fileContents = String(Files.readAllBytes(file.toPath()))
                        gson.fromJson<Any>(fileContents, MaterialStats::class.java)
                    } catch (e: IOException) {
                        Pewter.LOGGER.warn("File named ${file.name} could not be found?")
                        null
                    } catch (e: JsonSyntaxException) {
                        Pewter.LOGGER.warn("File named ${file.name} has a JSON syntax error!")
                        e.printStackTrace()
                        null
                    }
                    println("GOT THIS: $parsedStat")

                    parsedStat?.let { statList.add(it as MaterialStats) }
                }
            }
        }
        return statList
    }



    override fun init(e: FMLInitializationEvent) {
        Pewter.materials.map { it.tinkMaterial }.forEach {
            //it.addMaterialTraits()
        }

    }

    override fun postInit(e: FMLPostInitializationEvent) {
        Pewter.materials.forEach {
            it.integrate()
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
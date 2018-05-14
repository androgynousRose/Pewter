package com.ejektaflex.pewter.proxy

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.dsl.MaterialDSL
import com.ejektaflex.pewter.logic.MaterialStats
import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.integrations.ExampleMaterial
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.content.TinkerMaterials
import com.ejektaflex.pewter.content.TinkerModifiers
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.fluids.FluidRegistry
import net.minecraftforge.fml.common.Loader
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

    //private var internalModifiers = TinkerModifiers.modifiers
    private var internalMaterials = TinkerMaterials.materials

    override fun preInit(e: FMLPreInitializationEvent) {
        loadInternalData()
        loadExternalData()
        makePewterFluid()
        if (Pewter.materials.size == 0) {
            saveExampleMaterial()
        }
    }

    private fun saveExampleMaterial() {
        saveDSLMaterial(ExampleMaterial(), "_example")
    }

    private fun saveDSLMaterial(materialDSL: MaterialDSL, fileName: String? = null) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        try {
            FileWriter("${Pewter.CONFIGDIR}\\${fileName ?: materialDSL.tool.name}.json").use { writer ->
                gson.toJson(materialDSL.tool, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun loadInternalData(overwrite: Boolean = true) {
        for ((modName, modMaterialDSLs) in internalMaterials) {
            if (Loader.isModLoaded(modName)) {
                Pewter.LOGGER.info("Integrating $modName")
                for (dsl in modMaterialDSLs) {
                    if (dsl.tool.name !in Pewter.CONFIGDIR.listFiles().map { it.name } || overwrite) {
                        saveDSLMaterial(dsl)
                    } else {
                        Pewter.LOGGER.info("Skipping integration of ${dsl.tool.name}; file already exists")
                    }
                }
                Pewter.LOGGER.info("Finished integration with $modName")
            } else {
                Pewter.LOGGER.info("$modName is not loaded, skipping integration...")
            }
        }
    }

    private fun loadExternalData() {
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

                    parsedStat?.let { statList.add(it as MaterialStats) }
                }
            }
        }
        return statList
    }



    override fun init(e: FMLInitializationEvent) {
        Pewter.materials.forEach {
            it.associate()
            it.addMaterialTraits()
            it.represent()
        }
        addModifiers()
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        Pewter.materials.forEach {
            it.integrate()
        }
    }

    // Assign modifiers to items
    private fun addModifiers() {
        for (mod in TinkerModifiers.modifiers) {
            mod.key.apply(mod.value)
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
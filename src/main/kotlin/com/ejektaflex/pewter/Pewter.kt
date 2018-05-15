package com.ejektaflex.pewter

import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import java.io.File
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import com.ejektaflex.pewter.config.ConfigHandler


@Mod(modid = Pewter.MODID, name = Pewter.NAME, acceptedMinecraftVersions = Pewter.VERSIONS, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
object Pewter {


    var materials = mutableListOf<MaterialRegistrar>()

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog
        setupConfigHierarchy(event.modConfigurationDirectory)

        proxy.preInit(event)
        // Register model baking
        MinecraftForge.EVENT_BUS.register(proxy)
    }


    @EventHandler
    fun init(event: FMLInitializationEvent) {
        CONFIG.load()
        proxy.init(event)
    }

    @EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        CONFIG.save()
        proxy.postInit(event)
    }

    @EventHandler
    fun serverLoad(event: FMLServerStartingEvent) {
        event.registerServerCommand(Command())
    }

    private fun setupConfigHierarchy(base: File) {
        CONFIGDIR = ensureDirectory(base, MODID)
        BUILTINDIR = ensureDirectory(CONFIGDIR, "builtins")
        CUSTOMDIR = ensureDirectory(CONFIGDIR, "custom")
        CONFIG = ConfigHandler(CONFIGDIR.path)
    }

    private fun ensureDirectory(base: File, name: String): File {
        val newDir = File(base, name)
        if (!newDir.exists()) {
            newDir.mkdirs()
        }
        return newDir
    }

    const val MODID = "pewter"
    const val NAME = "Pewter"
    const val VERSION = "1.0"
    const val VERSIONS = "1.12"
    const val DEPENDS = "required-after:tconstruct;" +
            "required-after:forgelin;" +
            "after:astralsorcery;" +
            "after:thaumcraft;" +
            "after:betterwithmods;" +
            "after:botania;"
    const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    private const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
    private const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"

    lateinit var LOGGER: Logger
    lateinit var CONFIGDIR: File
    lateinit var BUILTINDIR: File
    lateinit var CUSTOMDIR: File
    lateinit var CONFIG: ConfigHandler

    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

package com.ejektaflex.pewter

import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import org.apache.logging.log4j.Logger


@Mod(modid = Pewter.MODID, name = Pewter.NAME, acceptedMinecraftVersions = Pewter.VERSIONS, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
object Pewter {

    var materials = mutableListOf<MaterialRegistrar>()

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog
        CONFIG = Configs
        CONFIG.initialize(event.modConfigurationDirectory)

        CONFIG.save()
        proxy.preInit(event)
        CONFIG.load()

        // Register model baking
        MinecraftForge.EVENT_BUS.register(proxy)
    }


    @EventHandler
    fun init(event: FMLInitializationEvent) {

        proxy.init(event)
    }

    @EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }

    @EventHandler
    fun serverLoad(event: FMLServerStartingEvent) {
        event.registerServerCommand(Command())
    }





    const val MODID = "pewter"
    const val NAME = "Pewter"
    const val VERSION = "0.4.0"
    const val VERSIONS = "1.12"
    const val DEPENDS = "required-after:tconstruct;" +
            "required-after:forgelin;" +
            "after:astralsorcery;" +
            "after:thaumcraft;" +
            "after:betterwithmods;" +
            "after:botania;" +
            "after:thebetweenlands;"
    const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    private const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
    private const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"

    lateinit var LOGGER: Logger
    lateinit var CONFIG: Configs

    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

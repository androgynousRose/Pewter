package com.ejektaflex.pewter

import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.logic.MaterialRegistrar
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLServerStartingEvent
import org.apache.logging.log4j.Logger
import slimeknights.tconstruct.library.modifiers.Modifier


@Mod(modid = Pewter.MODID, name = Pewter.NAME, acceptedMinecraftVersions = Pewter.VERSIONS, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
object Pewter : IProxy {

    @EventHandler
    override fun preInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog
        CONFIG = Configs
        CONFIG.initialize(event.modConfigurationDirectory)

        CONFIG.MAIN.grab()
        CONFIG.load()

        // Set integration


        proxy.preInit(event)

        CONFIG.MAIN.grab()
        CONFIG.save()


        // Register model baking
        MinecraftForge.EVENT_BUS.register(proxy)
    }

    fun isUsingConArm(): Boolean {
        return CONFIG.MAIN.conarmIntegration && Loader.isModLoaded("conarm")
    }

    @EventHandler
    override fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @EventHandler
    override fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }

    @EventHandler
    fun serverLoad(event: FMLServerStartingEvent) {
        event.registerServerCommand(DumpCommand())
    }



    const val MODID = "pewter"
    const val NAME = "Pewter"
    const val VERSION = "1.0.0b"
    const val VERSIONS = "1.12"
    const val DEPENDS = "required-after:tconstruct;" +
            "required-after:forgelin;" +
            "after:jaopca;" + // JAOPCA Compat?
            "after:conarm;" +
            "after:astralsorcery;" +
            "after:thaumcraft;" +
            "after:betterwithmods;" +
            "after:biomesoplenty;" +
            "after:botania;" +
            "after:thebetweenlands;"
    const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    private const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
    private const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"

    // For now, this feature has to go. Goodbye, custom load!
    var CUSTOM_LOAD = false

    lateinit var LOGGER: Logger
    lateinit var CONFIG: Configs

    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

package com.ejektaflex.pewter

import com.ejektaflex.pewter.api.PewterAPIProvider
import com.ejektaflex.pewter.command.PewterCommand
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.lib.InternalPewterAPI
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.*
import org.apache.logging.log4j.Logger


@Mod(modid = Pewter.MODID, name = Pewter.NAME, acceptedMinecraftVersions = Pewter.MCVERSION, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
object Pewter : IProxy {

    @EventHandler
    fun loadAPI(event: FMLConstructionEvent) = PewterAPIProvider.changeAPI(InternalPewterAPI)

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

    fun shouldLoadJsonContent(): Boolean {
        return CONFIG.MAIN.loadExternalContent
    }

    fun hasBlacklistedModifier(name: String): Boolean {
        return (name) in CONFIG.MAIN.blacklistedModifiers
    }

    fun isUsingConArm() = Pewter.CONFIG.MAIN.conarmIntegration && Loader.isModLoaded("conarm")

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
        event.registerServerCommand(PewterCommand())
    }

    const val MODID = "pewter"
    const val NAME = "Pewter"
    const val VERSION = "1.2.1"
    const val MCVERSION = "1.12"
    const val DEPENDS = "required-after:tconstruct;" +
            "required-after:forgelin;" +
            "after:jaopca;" +
            "after:conarm;" +
            "after:astralsorcery;" +
            "after:thaumcraft;" +
            "after:betterwithmods;" +
            "after:biomesoplenty;" +
            "after:botania;" +
            "after:thebetweenlands;" +
            "after:embers;" +
            "after:soot"
    const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    private const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
    private const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"

    var LOGGER: Logger? = null
    lateinit var CONFIG: Configs

    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

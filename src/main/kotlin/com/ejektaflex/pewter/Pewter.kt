package com.ejektaflex.pewter

import com.ejektaflex.pewter.api.PewterAPIProvider
import com.ejektaflex.pewter.command.PewterCommand
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.lib.InternalAPI
import com.ejektaflex.pewter.lib.PewterInfo
import com.ejektaflex.pewter.proxy.IProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.*


@Mod(modid = PewterInfo.MODID, name = PewterInfo.NAME, acceptedMinecraftVersions = PewterInfo.MCVERSION, version = PewterInfo.VERSION, dependencies = PewterInfo.DEPENDS, modLanguageAdapter = PewterInfo.ADAPTER)
object Pewter : IProxy {

    @EventHandler
    fun loadAPI(event: FMLConstructionEvent) = PewterAPIProvider.changeAPI(InternalAPI)

    @EventHandler
    override fun preInit(event: FMLPreInitializationEvent) {
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



    lateinit var CONFIG: Configs

    @SidedProxy(clientSide = PewterInfo.CLIENT, serverSide = PewterInfo.SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

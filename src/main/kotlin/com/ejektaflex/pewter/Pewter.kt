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
        //CONFIG = Configs
        Configs.initialize(event.modConfigurationDirectory)
        Configs.load()
        // Set integration
        proxy.preInit(event)
        Configs.save()
        // Register model baking
        MinecraftForge.EVENT_BUS.register(proxy)
    }

    @EventHandler
    override fun init(e: FMLInitializationEvent) {
        proxy.init(e)
    }

    @EventHandler
    override fun postInit(e: FMLPostInitializationEvent) {
        proxy.postInit(e)
    }

    @EventHandler
    fun serverLoad(e: FMLServerStartingEvent) {
        e.registerServerCommand(PewterCommand())
    }

    @SidedProxy(clientSide = PewterInfo.CLIENT, serverSide = PewterInfo.SERVER)
    @JvmStatic lateinit var proxy: IProxy

}

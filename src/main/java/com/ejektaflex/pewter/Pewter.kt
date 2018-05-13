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




@Mod(modid = Pewter.MODID, name = Pewter.NAME, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
class Pewter {

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        LOGGER = event.modLog

        CONFIGDIR = File(event.modConfigurationDirectory, MODID)

        if (!CONFIGDIR.exists()) {
            CONFIGDIR.mkdirs()
        }

        proxy.preInit(event)
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

    companion object {
        const val MODID = "pewter"
        const val NAME = "Pewter"
        const val VERSION = "1.0"
        const val DEPENDS = "required-after:tconstruct;" +
                "after:astralsorcery;" +
                "after:thaumcraft;" +
                "after:betterwithmods;"
        const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
        private const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
        private const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"

        lateinit var LOGGER: Logger
        lateinit var CONFIGDIR: File

        @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
        @JvmStatic lateinit var proxy: IProxy

        var materials = mutableListOf<MaterialRegistrar>()
    }
}

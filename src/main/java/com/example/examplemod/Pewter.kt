package com.example.examplemod

import com.example.examplemod.ext.toItemStack
import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

@Mod(modid = Pewter.MODID, name = Pewter.NAME, version = Pewter.VERSION, dependencies = Pewter.DEPENDS, modLanguageAdapter = Pewter.ADAPTER)
class Pewter {

    lateinit var logger: Logger

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.registryName)
        println("METTTAAAAAA ${"minecraft:dirt".toItemStack}")
    }

    companion object {
        const val MODID = "examplemod"
        const val NAME = "Example Mod"
        const val VERSION = "1.0"
        const val DEPENDS = "required:tconstruct"
        const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    }
}

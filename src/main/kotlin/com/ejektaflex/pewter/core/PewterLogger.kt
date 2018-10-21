package com.ejektaflex.pewter.core

import net.minecraft.launchwrapper.Launch
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager

object PewterLogger {

    private val logger = LogManager.getLogger("PewterAPI")
    private val levelVerbose: Level by lazy { Level.forName("VERBOSE", 350) }
    // Debug should only be enabled if someone passes "-Dcom.ejektaflex.pewter.verbose=true" to the JVM as a parameter
    // And in a deobfuscated environment. Debug just allows verbose log messages from Pewter.
    private val debugEnabled: Boolean by lazy {
        (Launch.blackboard["fml.deobfuscatedEnvironment"] as Boolean) && System.getProperty("com.ejektaflex.pewter.verbose") == "true"
    }

    fun verbose(any: Any) {
        if (debugEnabled) {
            logger.log(levelVerbose, any)
        }
    }

    fun info(any: Any) = logger.info(any)

    fun warn(any: Any) = logger.warn(any)

    fun fatal(any: Any) = logger.fatal(any)


}
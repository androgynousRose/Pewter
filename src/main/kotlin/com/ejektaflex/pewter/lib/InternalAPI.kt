package com.ejektaflex.pewter.lib

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.IPewterAPI
import com.ejektaflex.pewter.api.core.traits.IPewterTrait
import com.ejektaflex.pewter.api.core.materials.MaterialDSL
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.api.core.EffectWrapper
import com.ejektaflex.pewter.api.core.PewterModule
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.content.PewterContent
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import com.ejektaflex.pewter.content.PewterTraits
import net.minecraft.launchwrapper.Launch
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import slimeknights.mantle.client.book.repository.FileRepository
import slimeknights.tconstruct.library.events.MaterialEvent
import slimeknights.tconstruct.library.materials.IMaterialStats


object InternalAPI : IPewterAPI {

    private val logger = LogManager.getLogger("PewterAPI")
    private val levelVerbose: Level by lazy { Level.forName("VERBOSE", 350) }
    // Debug should only be enabled if someone passes "-Dcom.ejektaflex.pewter.verbose=true" to the JVM as a parameter
    // Debug just allows verbose log messages from Pewter.
    private val debugEnabled: Boolean by lazy {
        (Launch.blackboard["fml.deobfuscatedEnvironment"] as Boolean) && System.getProperty("com.ejektaflex.pewter.verbose") == "true"
    }

    override fun addToolModifier(mod: EffectWrapper<out IPewterToolModifier>) {
        PewterModifiers.internalContent.add(mod)
    }

    override fun addArmorModifier(mod: EffectWrapper<out IPewterArmorModifier>) {
        if (Pewter.isUsingConArm()) {
            PewterModifiers.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Modifier '${mod.identifier}'!")
        }
    }

    override fun addToolTrait(mod: EffectWrapper<out IPewterTrait>) {
        PewterTraits.internalContent.add(mod)
    }

    override fun addArmorTrait(mod: EffectWrapper<out IPewterTrait>) {
        if (Pewter.isUsingConArm()) {
            PewterTraits.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Trait '${mod.identifier}'!")
        }
    }

    override fun addMaterial(material: MaterialDSL) {
        PewterMaterials.internalContent.add(material)
    }

    fun verbose(any: Any) {
        if (debugEnabled) {
            logger.log(levelVerbose, any)
        }
    }

    fun info(any: Any) = logger.info(any)

    fun warn(any: Any) = logger.warn(any)

    fun fatal(any: Any) = logger.fatal(any)

    override fun registerModule(module: PewterModule) {
        PewterContent.registerModule(module)
    }

    override fun addToolRepository(location: String) {
        try {
            val repo = FileRepository(location)
            BookContentRegistry.toolContent.add(repo)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun addArmorRepository(location: String) {
        try {
            val repo = FileRepository(location)
            BookContentRegistry.armorContent.add(repo)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * If the user has any custom JSON content with an identifier that matches
     * the material identifier, it will instead load the custom stats. This
     * allows users to override stats in materials from other mods.
     */
    @SubscribeEvent
    fun catchStats(e: MaterialEvent.StatRegisterEvent<IMaterialStats>) {
        val jsonMaterial = Configs.externalMaterials.find { it.name == e.material.identifier }
        if (jsonMaterial != null) {
            val jsonPartStat = jsonMaterial.matParts.find { it.dependency == e.stats.identifier }
            jsonPartStat?.let {
                e.overrideResult(jsonPartStat.stats(jsonMaterial))
            }
        }
    }

}
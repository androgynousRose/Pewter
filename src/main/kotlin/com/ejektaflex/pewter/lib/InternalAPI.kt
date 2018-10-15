package com.ejektaflex.pewter.lib

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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import slimeknights.mantle.client.book.repository.FileRepository
import slimeknights.tconstruct.library.events.MaterialEvent
import slimeknights.tconstruct.library.materials.IMaterialStats


object InternalAPI : IPewterAPI {

    override fun addToolModifier(mod: EffectWrapper<out IPewterToolModifier>) {
        PewterModifiers.internalContent.add(mod)
    }

    override fun addArmorModifier(mod: EffectWrapper<out IPewterArmorModifier>) {
        if (Configs.main.isUsingConArm()) {
            PewterModifiers.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Modifier '${mod.identifier}'!")
        }
    }

    override fun addToolTrait(mod: EffectWrapper<out IPewterTrait>) {
        PewterTraits.internalContent.add(mod)
    }

    override fun addArmorTrait(mod: EffectWrapper<out IPewterTrait>) {
        if (Configs.main.isUsingConArm()) {
            PewterTraits.internalContent.add(mod)
        } else {
            throw Exception("Pewter is not using Construct's Armory, cannot add Armor Trait '${mod.identifier}'!")
        }
    }

    override fun addMaterial(material: MaterialDSL) {
        PewterMaterials.internalContent.add(material)
    }

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
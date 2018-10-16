package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers
import net.minecraftforge.fml.common.Loader

open class MainConfig(folder: String) : KConfig(folder, "pewter.cfg") {
    private var conarmIntegration: Boolean = true
    private var loadExternalContent: Boolean = false
    private var loadPewter: Boolean = false

    //var materialsToList = listOf<MaterialRegistrar>()
    private var blacklistedMaterials = mutableListOf<String>()
    private var blacklistedModifiers = mutableListOf<String>()

    fun shouldLoadJsonContent(): Boolean {
        return loadExternalContent
    }

    fun shouldLoadPewterContent(): Boolean {
        return loadPewter
    }

    fun hasBlacklistedMaterial(name: String): Boolean {
        return name in blacklistedMaterials
    }

    fun hasBlacklistedModifier(name: String): Boolean {
        return name in blacklistedModifiers
    }

    fun isUsingConArm() = conarmIntegration && Loader.isModLoaded("conarm")

    fun grab() {

        loadPewter = config.get(
                CATEGORY_GENERAL,
                "LoadPewterContent",
                true,
                "If set to false, Pewter will not load any of it's own content."
        ).boolean

        conarmIntegration = config.get(
                CATEGORY_GENERAL,
                "ConstructsArmoryIntegration",
                true,
                "Toggles Construct's Armory integration for Pewter."
        ).boolean

        loadExternalContent = config.get(
                CATEGORY_GENERAL,
                "LoadMaterialJSONS",
                false,
                "If set to true, will load json files from the config folder (besides _example.json) as custom materials. For more info, see: https://github.com/ejektaflex/Pewter/wiki/Custom-Materials"
        ).boolean


        val mats = PewterMaterials.content
        val catName = "material blacklist:"
        config.addCustomCategoryComment(catName, "Possible materials you can blacklist:\n ${mats.map { it.data.name }.sorted()}")

        val got = config.getStringList(
                "materialBlacklist",
                catName,
                listOf<String>().toTypedArray(),
                "Blacklist for Pewter Materials. Add the materials you don't want and they will not be loaded on startup"
        )
        got.forEach { blacklistedMaterials.add(it) }


        val modNames = PewterModifiers.internalContent.map { it.identifier }
        val catNameMods = "modifier blacklist:"
        config.addCustomCategoryComment(catNameMods, "Possible modifiers you can blacklist:\n ${modNames.sorted()}")

        val gotMods = config.getStringList(
                "materialBlacklist",
                catNameMods,
                listOf<String>().toTypedArray(),
                "Blacklist for Pewter Modifiers. Add the modifiers you don't want and they will not be loaded on startup"
        )
        gotMods.forEach { blacklistedModifiers.add(it) }

    }

    companion object {
        private const val CATEGORY_GENERAL = "general"
    }

}

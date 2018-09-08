package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.content.PewterModifiers

open class MainConfig(folder: String) : KConfig(folder, "pewter.cfg") {
    open var conarmIntegration: Boolean = true
    open var loadExternalContent: Boolean = false

    //var materialsToList = listOf<MaterialRegistrar>()
    var blacklistedMaterials = mutableListOf<String>()
    var blacklistedModifiers = mutableListOf<String>()

    fun grab() {
        conarmIntegration = config.get(
                CATEGORY_GENERAL,
                "ConstructsArmoryIntegration",
                true,
                "If set to true, will add dependencies as armor to Construct's Armory where available"
        ).boolean

        loadExternalContent = config.get(
                CATEGORY_GENERAL,
                "LoadMaterialJSONS",
                false,
                "If set to true, will load json files from the config folder (besides _example.json)"
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


        val modNames = PewterModifiers.contentDefs.map { it.name }
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

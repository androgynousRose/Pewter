package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.PewterMaterials

open class MainConfig(folder: String) : KConfig(folder, "pewter.cfg") {
    open var overwrite: Boolean = true
    open var purge: Boolean = true
    open var conarmIntegration: Boolean = true

    var blacklistedMaterials = mutableListOf<String>()

    init {
        grab()
    }

    private fun grab() {
        overwrite = config.get(
                CATEGORY_GENERAL,
                "lockedIntegrations",
                true,
                "If set to false, you can customize dependencies in the ${Pewter.MODID}/builtins folder and they won't be overwritten."
        ).boolean

        purge = config.get(
                CATEGORY_GENERAL,
                "purgeUnusedIntegrations",
                true,
                "If set to true, will remove integration files for dependencies that have been turned off"
        ).boolean

        conarmIntegration = config.get(
                CATEGORY_GENERAL,
                "ConstructsArmoryIntegration",
                true,
                "If set to true, will add dependencies as armor to Construct's Armory where available"
        ).boolean

        val mats = PewterMaterials.content
        val catName = "material blacklist:"
        config.addCustomCategoryComment(catName, "Possible dependencies you can blacklist: ${mats.map { it.material.name }}")

        val got = config.getStringList(
                "materialBlacklist",
                catName,
                listOf<String>().toTypedArray(),
                "Blacklist for Pewter. Add the dependencies you don't want and they will not be loaded on startup"
        )
        got.forEach { blacklistedMaterials.add(it) }

    }

    companion object {
        private const val CATEGORY_GENERAL = "general"
    }

}

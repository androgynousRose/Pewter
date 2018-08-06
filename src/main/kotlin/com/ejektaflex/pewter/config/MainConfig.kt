package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.TinkerMaterials

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
                "If set to false, you can customize materials in the ${Pewter.MODID}/builtins folder and they won't be overwritten."
        ).boolean

        purge = config.get(
                CATEGORY_GENERAL,
                "purgeUnusedIntegrations",
                true,
                "If set to true, will remove integration files for materials that have been turned off"
        ).boolean

        conarmIntegration = config.get(
                CATEGORY_GENERAL,
                "ConstructsArmoryIntegration",
                true,
                "If set to true, will add materials as armor to Construct's Armory where available"
        ).boolean

        for ((mod, materialList) in TinkerMaterials.materials) {
            val catName = "material blacklist: $mod"
            val comment = "Possible materials you can blacklist: ${materialList.map { it.material.name }}"
            config.addCustomCategoryComment(catName, comment)
            val got = config.getStringList(
                    "materialBlacklist",
                    catName,
                    listOf<String>().toTypedArray(),
                    "Blacklist for $mod. Add the materials you don't want and they will not be loaded on startup"
            )
            got.forEach { blacklistedMaterials.add(it) }
        }

    }

    companion object {
        private const val CATEGORY_GENERAL = "general"
    }

}

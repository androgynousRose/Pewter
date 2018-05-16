package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.TinkerMaterials

open class MainConfig(folder: String) : KConfig(folder, "pewter.cfg") {
    open var overwrite: Boolean = true
    open var purge: Boolean = true

    var builtinsToLoad = mutableListOf<String>()

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
                "If set to true, will remove integration files for integrations that have been turned off"
        ).boolean

        for ((mod, materialList) in TinkerMaterials.materials) {
            val got = config.getStringList(
                    "materials",
                    "materials: $mod",
                    materialList.map { it.tool.name }.toTypedArray(),
                    "Integrations for $mod. Delete the ones you don't want and they will not be loaded on startup"
            )
            got.forEach { builtinsToLoad.add(it) }
        }

    }

    companion object {
        private const val CATEGORY_GENERAL = "general"
    }

}

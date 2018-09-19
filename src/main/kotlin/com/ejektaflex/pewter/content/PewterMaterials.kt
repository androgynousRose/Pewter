package com.ejektaflex.pewter.content

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.logic.MaterialRegistrar

object PewterMaterials : AbstractLoadable<MaterialRegistrar, MaterialDSL>() {

    override fun get(id: String): MaterialRegistrar? {
        return content.find { it.data.name == id }
    }

    override fun transformContent(items: List<MaterialDSL>): List<MaterialRegistrar> {
        val toLoad = (internalContent).asSequence().mapNotNull {
            dependencyCheck(it)
        }.toMutableList()

        if (Pewter.shouldLoadJsonContent()) {
            toLoad += loadJsonContent()
        }

        return toLoad
    }

    private fun loadJsonContent(): List<MaterialRegistrar> {
        return Configs.externalMaterials.map { MaterialRegistrar(it) }
    }

    private fun dependencyCheck(matDSL: MaterialDSL): MaterialRegistrar? {
        return if (matDSL.hasMetDependencies()) {
            MaterialRegistrar(matDSL.material)
        } else {
            null
        }
    }

}
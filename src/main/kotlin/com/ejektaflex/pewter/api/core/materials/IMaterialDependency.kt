package com.ejektaflex.pewter.api.core.materials

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.api.core.materials.stats.IDependency
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData

interface IMaterialDependency : IDependency {
    val material: MaterialData

    val isBlackListed: Boolean
        get() = material.name in Pewter.blacklistedMaterials

}
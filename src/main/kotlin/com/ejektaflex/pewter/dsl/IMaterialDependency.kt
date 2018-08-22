package com.ejektaflex.pewter.dsl

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.content.IDependency
import com.ejektaflex.pewter.logic.stats.MaterialData

interface IMaterialDependency : IDependency {
    val material: MaterialData

    val isBlackListed: Boolean
        get() = material.name in Pewter.CONFIG.MAIN.blacklistedMaterials

}
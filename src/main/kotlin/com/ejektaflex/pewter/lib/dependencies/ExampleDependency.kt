package com.ejektaflex.pewter.lib.dependencies

import com.ejektaflex.pewter.api.materials.IMaterialDependency


interface ExampleDependency : IMaterialDependency {
    override fun hasMetDependencies() = false
}
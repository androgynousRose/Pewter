package com.ejektaflex.pewter.lib.dependencies

import com.ejektaflex.pewter.dsl.IMaterialDependency

interface ExampleDependency : IMaterialDependency {
    override fun hasMetDependencies() = false
}
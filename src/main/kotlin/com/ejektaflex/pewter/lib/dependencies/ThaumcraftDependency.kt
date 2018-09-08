package com.ejektaflex.pewter.lib.dependencies

import com.ejektaflex.pewter.api.materials.IMaterialDependency
import net.minecraftforge.fml.common.Loader

interface ThaumcraftDependency : IMaterialDependency {
    override fun hasMetDependencies(): Boolean {
        return Loader.isModLoaded("thaumcraft") && !isBlackListed
    }
}
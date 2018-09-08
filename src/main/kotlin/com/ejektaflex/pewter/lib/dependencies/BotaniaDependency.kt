package com.ejektaflex.pewter.lib.dependencies

import com.ejektaflex.pewter.api.materials.IMaterialDependency
import net.minecraftforge.fml.common.Loader

interface BotaniaDependency : IMaterialDependency {
    override fun hasMetDependencies() = Loader.isModLoaded("botania") && !isBlackListed
}
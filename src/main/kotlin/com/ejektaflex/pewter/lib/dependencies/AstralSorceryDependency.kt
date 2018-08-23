package com.ejektaflex.pewter.lib.dependencies

import com.ejektaflex.pewter.dsl.IMaterialDependency
import net.minecraftforge.fml.common.Loader

interface AstralSorceryDependency : IMaterialDependency {
    override fun hasMetDependencies() = Loader.isModLoaded("astralsorcery") && !isBlackListed
}
package com.ejektaflex.pewter.ext

import com.ejektaflex.pewter.Pewter
import net.minecraft.util.ResourceLocation

val String.resource: ResourceLocation
    get() = ResourceLocation(Pewter.MODID, this)
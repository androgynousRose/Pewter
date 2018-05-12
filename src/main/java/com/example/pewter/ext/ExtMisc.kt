package com.example.pewter.ext

import com.example.pewter.Pewter
import net.minecraft.util.ResourceLocation

val String.resource: ResourceLocation
    get() = ResourceLocation(Pewter.MODID, this)
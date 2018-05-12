package com.example.examplemod.ext

import com.example.examplemod.Pewter
import net.minecraft.util.ResourceLocation

val String.resource: ResourceLocation
    get() = ResourceLocation(Pewter.MODID, this)
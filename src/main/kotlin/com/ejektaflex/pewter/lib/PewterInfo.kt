package com.ejektaflex.pewter.lib

object PewterInfo {
    const val MODID = "pewter"
    const val NAME = "Pewter"
    const val VERSION = "1.4.1"
    const val MCVERSION = "1.12"
    const val DEPENDS = "required-after:tconstruct;" +
            "required-after:forgelin;" +
            "after:jaopca;" +
            "after:conarm;" +
            "after:astralsorcery;" +
            "after:thaumcraft;" +
            "after:betterwithmods;" +
            "after:biomesoplenty;" +
            "after:botania;" +
            "after:thebetweenlands;" +
            "after:embers;" +
            "after:mekanism;" +
            "after:soot"
    const val ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
    const val CLIENT = "com.ejektaflex.pewter.proxy.ClientProxy"
    const val SERVER = "com.ejektaflex.pewter.proxy.CommonProxy"
}
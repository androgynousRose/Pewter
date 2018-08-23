package com.ejektaflex.pewter.config

import net.minecraftforge.common.config.Configuration
import java.io.File

open class KConfig(folder: String, fileName: String) {
    protected var config: Configuration = Configuration(File(folder, fileName))

    open fun load() = config.load()
    open fun save() = config.save()

    open fun hasChanged() = config.hasChanged()

    
}
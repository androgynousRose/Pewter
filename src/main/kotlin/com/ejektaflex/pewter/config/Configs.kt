package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import java.io.File

object Configs {

    private lateinit var DIR: File
    lateinit var BUILTINDIR: File
    lateinit var CUSTOMDIR: File

    lateinit var MAIN: MainConfig

    private fun ensureDirectory(base: File, name: String): File {
        val newDir = File(base, name)
        if (!newDir.exists()) {
            newDir.mkdirs()
        }
        return newDir
    }


    fun save() {
        MAIN.save()
    }

    fun load() {
        MAIN.load()
    }

    fun initialize(root: File) {
        DIR = ensureDirectory(root, Pewter.MODID)
        if (Pewter.CUSTOM_LOAD) {
            BUILTINDIR = ensureDirectory(DIR, "builtin")
            CUSTOMDIR = ensureDirectory(DIR, "custom")
        }
        MAIN = MainConfig(DIR.path)
    }


}
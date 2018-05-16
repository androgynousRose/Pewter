package com.ejektaflex.pewter.config

import com.ejektaflex.pewter.Pewter
import java.io.File

object Configs {

    private lateinit var DIR: File
    private lateinit var MATERIALDIR: File
    lateinit var BUILTINDIR: File
    lateinit var CUSTOMDIR: File

    lateinit var MAIN: MainConfig
    //lateinit var TRAITS: TraitConfig

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
        MATERIALDIR = ensureDirectory(DIR, "materials")
        BUILTINDIR = ensureDirectory(MATERIALDIR, "builtin")
        CUSTOMDIR = ensureDirectory(MATERIALDIR, "custom")
        MAIN = MainConfig(DIR.path)
    }


}
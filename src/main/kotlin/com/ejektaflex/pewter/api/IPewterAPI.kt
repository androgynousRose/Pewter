package com.ejektaflex.pewter.api

import com.ejektaflex.pewter.api.materials.MaterialDSL
import com.ejektaflex.pewter.api.materials.stats.MaterialData
import com.ejektaflex.pewter.lib.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.lib.modifiers.PewterToolModifier

interface IPewterAPI {

    fun addMaterial(material: MaterialDSL)

    fun addMaterial(material: MaterialData)

    fun addToolModifier(mod: PewterToolModifier)

    fun addArmorModifier(mod: PewterArmorModifier)

}
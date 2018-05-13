package com.ejektaflex.pewter

import net.minecraft.client.resources.IResourceManagerReloadListener
import net.minecraft.util.text.translation.LanguageMap
import java.io.ByteArrayInputStream
import net.minecraft.client.Minecraft
import net.minecraft.client.resources.IResourceManager



class ResourceManager : IResourceManagerReloadListener {
    override fun onResourceManagerReload(resourceManager: IResourceManager) {
        var data = ""
        for (mat in Pewter.materials) {
            for ((locName, value) in mat.stats.nameLocales) {
                val materialName = mat.stats.name.toLowerCase()
                if (locName.toLowerCase() == Minecraft.getMinecraft().languageManager.currentLanguage.languageCode.toLowerCase()) {
                    // Material entry in book
                    data += "material.$materialName.name=$value\n"
                    // Fluid entry & Bucket Entry
                    data += "fluid.${Pewter.MODID}.$materialName.name=$value\n"
                }
            }
        }
        LanguageMap.inject(ByteArrayInputStream(data.toByteArray()))
    }
}
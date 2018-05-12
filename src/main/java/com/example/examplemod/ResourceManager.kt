package com.example.examplemod

import net.minecraft.client.resources.IResourceManagerReloadListener
import net.minecraft.util.text.translation.LanguageMap
import java.io.ByteArrayInputStream
import net.minecraft.client.Minecraft
import net.minecraft.client.resources.IResourceManager



class ResourceManager : IResourceManagerReloadListener {
    override fun onResourceManagerReload(resourceManager: IResourceManager) {
        var data = ""
        for (mat in Pewter.materials) {
            for ((locName, value) in mat.nameLocales) {
                val materialName = mat.tool.name.toLowerCase()
                if (locName.toLowerCase() == Minecraft.getMinecraft().languageManager.currentLanguage.languageCode.toLowerCase()) {
                    data += "material.$materialName.name=$value\n"
                }
            }
        }
        LanguageMap.inject(ByteArrayInputStream(data.toByteArray()))
    }
}
package com.ejektaflex.pewter

import com.ejektaflex.pewter.content.TinkerModifiers
import com.ejektaflex.pewter.content.TinkerTraits
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
                    // Flavour text (Sadly does not work)
                    data += "$materialName.flavour=helloworld\n"
                }
            }
        }

        for (trait in TinkerTraits.traits) {
            data += "modifier.${trait.identifier}.name=${trait.name}\n"
            data += "modifier.${trait.identifier}.desc=§o${trait.motto}§r\\n${trait.description}\n"
        }

        for (mod in TinkerModifiers.modifiers.keys) {
            data += "modifier.${mod.identifier}.name=${mod.name}\n"
            data += "modifier.${mod.identifier}.desc=§o${mod.motto}§r\\n${mod.description}\n"
        }

        LanguageMap.inject(ByteArrayInputStream(data.toByteArray()))
    }
}
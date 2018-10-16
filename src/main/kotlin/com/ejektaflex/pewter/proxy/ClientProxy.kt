package com.ejektaflex.pewter.proxy

import com.ejektaflex.pewter.api.PewterAPI
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.lib.BookContentRegistry
import com.ejektaflex.pewter.lib.PewterInfo
import com.ejektaflex.pewter.lib.PewterLogger
import com.ejektaflex.pewter.logic.FluidStateMapper
import com.ejektaflex.pewter.logic.ResourceManager
import com.google.common.base.Function
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.block.model.IBakedModel
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.resources.IReloadableResourceManager
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelBakeEvent
import net.minecraftforge.client.model.Attributes
import net.minecraftforge.client.model.IModel
import net.minecraftforge.client.model.ModelFluid
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import slimeknights.tconstruct.library.client.MaterialRenderInfo
import java.awt.Color


class ClientProxy : CommonProxy() {

    override fun preInit(e: FMLPreInitializationEvent) {
        super.preInit(e)

        for (material in PewterMaterials) {
            material.fluid?.let {
                val mapper = FluidStateMapper(it)
                // Item Model
                if (material.fluidItem != null) {
                    ModelLoader.registerItemVariants(material.fluidItem!!)
                    ModelLoader.setCustomMeshDefinition(material.fluidItem!!, mapper)
                }
                // Block Model
                if (material.block != null) {
                    ModelLoader.setCustomStateMapper(material.block!!, mapper)
                }
            }
            material.tinkMaterial.setRenderInfo(
                    MaterialRenderInfo.Metal(Color.decode(material.data.color).rgb,
                            material.data.looks.shininess,
                            material.data.looks.brightness,
                            material.data.looks.hueshift
                    )
            )
        }

        // Load localizations
        (Minecraft.getMinecraft().resourceManager as IReloadableResourceManager).registerReloadListener(ResourceManager())
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        super.postInit(e)
        PewterLogger.info("Adding Pewter content to Tinker-based books..")
        PewterAPI.addToolRepository("${PewterInfo.MODID}:tinker_book")
        PewterAPI.addArmorRepository("${PewterInfo.MODID}:armory_book")

        BookContentRegistry.setup()
    }

    override fun makePewterFluid() {
        super.makePewterFluid()
        val mapper = FluidStateMapper(fluid)
        // Item Model
        ModelLoader.registerItemVariants(item)
        ModelLoader.setCustomMeshDefinition(item, mapper)
        // Block Model
        ModelLoader.setCustomStateMapper(block, mapper)
    }

    @SubscribeEvent
    fun onModelBake(event: ModelBakeEvent) {
        var location: ModelResourceLocation
        var model: IModel
        var baked: IBakedModel
        for (mat in PewterMaterials) {
            if (mat.fluid != null) {
                model = ModelFluid(mat.fluid!!)
                baked = model.bake(model.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT, textureGetter)
                location = ModelResourceLocation(PewterInfo.MODID + ":fluid_block", mat.fluid!!.name)
                event.modelRegistry.putObject(location, baked)
            }
        }
    }

    companion object {
        @JvmStatic
        var textureGetter: Function<ResourceLocation, TextureAtlasSprite> = Function {
            location -> Minecraft.getMinecraft().textureMapBlocks.getAtlasSprite(location.toString())
        }
    }

}
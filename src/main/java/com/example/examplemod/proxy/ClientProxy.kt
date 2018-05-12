package com.example.examplemod.proxy

import com.google.common.base.Function

import com.example.examplemod.Pewter
import com.example.examplemod.ResourceManager
import com.example.examplemod.logic.FluidStateMapper
import net.minecraft.client.Minecraft
import net.minecraft.client.resources.IReloadableResourceManager
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import slimeknights.tconstruct.library.client.MaterialRenderInfo
import slimeknights.tconstruct.library.Util.MODID
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraftforge.client.model.Attributes.DEFAULT_BAKED_FORMAT
import net.minecraftforge.client.model.ModelFluid
import net.minecraft.creativetab.CreativeTabs.MATERIALS
import net.minecraft.client.renderer.block.model.IBakedModel
import net.minecraftforge.client.model.IModel
import net.minecraftforge.client.event.ModelBakeEvent
import net.minecraftforge.client.model.Attributes
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraft.util.ResourceLocation
import net.minecraft.client.renderer.texture.TextureAtlasSprite





class ClientProxy : CommonProxy() {

    override fun preInit(e: FMLPreInitializationEvent) {
        super.preInit(e)

        Pewter.materials.forEach { material ->
            material.matFluid?.let {
                println("MAPPING FLUID ${it.name}")
                val mapper = FluidStateMapper(it)
                // Item Model
                ModelLoader.registerItemVariants(material.fluidItem)
                ModelLoader.setCustomMeshDefinition(material.fluidItem, mapper)
                // Block Model
                println("SETTING BLOCK MODEL FOR BLOCK: ${material.matBlock}")
                ModelLoader.setCustomStateMapper(material.matBlock, mapper)
            }
            material.material.setRenderInfo(MaterialRenderInfo.Metal(material.tool.color, 0.25f, 0.5f, -0.1f))
        }


        // Load localizations
        (Minecraft.getMinecraft().resourceManager as IReloadableResourceManager).registerReloadListener(ResourceManager())
    }

    override fun init(e: FMLInitializationEvent) {
        super.init(e)
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        super.postInit(e)
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
        for (mat in Pewter.materials) {
            if (mat.matFluid != null) {
                model = ModelFluid(mat.matFluid!!)
                baked = model.bake(model.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT, textureGetter)
                location = ModelResourceLocation(Pewter.MODID + ":fluid_block", mat.matFluid!!.name)
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
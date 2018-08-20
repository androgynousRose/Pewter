package com.ejektaflex.pewter.proxy

import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.ResourceManager
import com.ejektaflex.pewter.book.PewterModSectionTransformer
import com.ejektaflex.pewter.ext.resource
import com.ejektaflex.pewter.logic.FluidStateMapper
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
import slimeknights.mantle.client.book.BookTransformer
import slimeknights.mantle.client.book.data.content.ContentTableOfContents
import slimeknights.mantle.client.book.repository.BookRepository
import slimeknights.mantle.client.book.repository.FileRepository
import slimeknights.tconstruct.library.book.TinkerBook
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer
import slimeknights.tconstruct.library.book.sectiontransformer.ModifierSectionTransformer
import slimeknights.tconstruct.library.client.MaterialRenderInfo
import java.awt.Color


class ClientProxy : CommonProxy() {

    override fun preInit(e: FMLPreInitializationEvent) {
        super.preInit(e)

        Pewter.materials.forEach { material ->
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
                    MaterialRenderInfo.Metal(Color.decode(material.stats.color).rgb,
                            material.stats.looks["shininess"] ?: 1.0f,
                            material.stats.looks["brightness"] ?: 1.0f,
                            material.stats.looks["hueshift"] ?: 1.0f
                    )
            )
        }

        // Load localizations
        (Minecraft.getMinecraft().resourceManager as IReloadableResourceManager).registerReloadListener(ResourceManager())
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        super.postInit(e)

        //*
        val repo = FileRepository("${Pewter.MODID}:book")
        TinkerBook.INSTANCE.addRepository(repo)
        println(repo.sections.map { it.name })
        TinkerBook.INSTANCE.addTransformer(PewterModSectionTransformer(repo.sections[0].name))
        //TinkerBook.INSTANCE.addTransformer(PewterModSectionTransformer("pewter_modifiers"))
        Pewter.LOGGER.info("Added modifiers to book.")
        //*/

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
            if (mat.fluid != null) {
                model = ModelFluid(mat.fluid!!)
                baked = model.bake(model.getDefaultState(), Attributes.DEFAULT_BAKED_FORMAT, textureGetter)
                location = ModelResourceLocation(Pewter.MODID + ":fluid_block", mat.fluid!!.name)
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
package com.example.examplemod.logic

import com.example.examplemod.ext.resource
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.Fluid
import net.minecraft.client.renderer.ItemMeshDefinition
import net.minecraft.client.renderer.block.statemap.StateMapperBase


class FluidStateMapper(fluid: Fluid) : StateMapperBase(), ItemMeshDefinition {
    private val location: ModelResourceLocation = ModelResourceLocation("fluid_block".resource, fluid.name)

    override fun getModelLocation(stack: ItemStack): ModelResourceLocation {
        return location
    }

    override fun getModelResourceLocation(state: IBlockState): ModelResourceLocation {
        return location
    }
}
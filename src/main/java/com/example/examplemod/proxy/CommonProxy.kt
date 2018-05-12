package com.example.examplemod.proxy

import com.example.examplemod.dsl.NewMaterial
import com.example.examplemod.ext.times
import net.minecraft.init.Items
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy : IProxy {

    var mats = mutableListOf<NewMaterial>()

    override fun preInit(e: FMLPreInitializationEvent) {
        val mat1 = NewMaterial {
            name { "doot" }
            forge { true }
            ingot { Items.APPLE * 1 }
            head   {    durability { 100 };     attack { 5 };       speed { 1 } }
            handle {    durability { 50 };      mult { 1f } }
            extra  {    durability { 25 } }
            bow    {    accuracy { 0.5f };      range { 10 } }
            shaft  {    modifier { 1.1f };      bonusAmmo { 5 } }
        }
        mats.add(mat1)
    }

    override fun init(e: FMLInitializationEvent) {
        mats.map { it.material }.forEach {
            //it.addMaterialTraits()
        }
    }

    override fun postInit(e: FMLPostInitializationEvent) {
        mats.forEach {
            it.integrate()
        }
    }

}
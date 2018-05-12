package com.example.examplemod.proxy

import com.example.examplemod.Pewter
import com.example.examplemod.dsl.NewMaterial
import com.example.examplemod.ext.times
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy : IProxy {


    override fun preInit(e: FMLPreInitializationEvent) {
        val mat1 = NewMaterial("hello", 0x888888) {
            locale("en_US" to "Test Material.")
            forge { true }
            craft { false }
            ingots("minecraft:apple")
            icon("minecraft:apple")
            head {
                durability { 100 }
                attack { 5 }
                speed { 1f }
            }
            handle {
                durability { 50 }
                mult { 1f }
            }
            extra {
                durability { 25 }
            }
            bow {
                accuracy { 0.5f }
                range { 1f }
                string { 1.1f }
                bonusDamage { 5f }
            }
            shaft {
                modifier { 1.1f }
                bonusAmmo { 5 }
            }
        }
        Pewter.materials.add(mat1)
    }

    override fun init(e: FMLInitializationEvent) {
        Pewter.materials.map { it.material }.forEach {
            //it.addMaterialTraits()
        }

    }

    override fun postInit(e: FMLPostInitializationEvent) {
        Pewter.materials.forEach {
            it.integrate()
        }
    }

}
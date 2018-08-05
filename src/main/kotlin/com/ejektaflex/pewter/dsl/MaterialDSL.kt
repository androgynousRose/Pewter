package com.ejektaflex.pewter.dsl

import com.ejektaflex.pewter.logic.stats.ArmorStats
import com.ejektaflex.pewter.logic.stats.MaterialStats

open class MaterialDSL(initName: String, initColor: String, initFunc: MaterialDSL.() -> Unit) : DSL<MaterialDSL>() {

    var material = MaterialStats()

    init {
        material.color = initColor
        material.name = initName
        apply(initFunc)
    }

    @DslMarker
    annotation class TopLevelToolDSL

    @DslMarker
    annotation class NestedDSL

    @TopLevelToolDSL
    fun locale(vararg pairs: Pair<String, String>) {
        material.nameLocales = pairs.toMap().toMutableMap()
    }

    @TopLevelToolDSL
    fun parts(vararg someParts: MaterialStats.MatPart) {
        someParts.forEach { material.matParts.add(it) }
    }

    @TopLevelToolDSL
    fun meltsAt(n: Int) {
        material.meltingTemperature = n
    }

    @TopLevelToolDSL
    fun shininess(f: Float) {
        material.looks["shininess"] = f
    }

    @TopLevelToolDSL
    fun defaultMetalParts() {
        // No fletching or bowstring
        val metalParts = arrayOf(
                MaterialStats.MatPart.HEAD,
                MaterialStats.MatPart.HANDLE,
                MaterialStats.MatPart.EXTRA,
                MaterialStats.MatPart.BOW,
                MaterialStats.MatPart.PROJECTILE,
                // Armor
                MaterialStats.MatPart.CORE,
                MaterialStats.MatPart.PLATES,
                MaterialStats.MatPart.TRIM
        )
        parts(*metalParts)
    }


    @TopLevelToolDSL
    fun traitList(vararg pairs: Pair<String, String>) {
        for (pair in pairs) {
            if (pair.first.toUpperCase() in MaterialStats.MatPart.values().map { it.toString() }) {
                // Add specific trait key if it doesn't exist
                if (pair.first !in material.specificTraits.keys) {
                    material.specificTraits[pair.first] = mutableListOf()
                }
                material.specificTraits[pair.first]!!.add(pair.second)
            }
        }
    }

    @TopLevelToolDSL
    fun ingots(vararg ing: String) {
        // Add all ingots to map
        material.smelting["ingot"]!!.addAll(ing)
    }

    @TopLevelToolDSL
    fun blocks(vararg blo: String) {
        material.smelting["block"]!!.addAll(blo)
    }

    @TopLevelToolDSL
    fun nuggets(vararg blo: String) {
        material.smelting["nugget"]!!.addAll(blo)
    }

    @TopLevelToolDSL
    fun ores(vararg blo: String) {
        material.smelting["ore"]!!.addAll(blo)
    }

    @TopLevelToolDSL
    fun forge(func: () -> Boolean) {
        material.madeInToolForge = func()
    }

    @TopLevelToolDSL
    fun craft(func: () -> Boolean) {
        material.craftable = func()
    }

    @TopLevelToolDSL
    fun tool(func: ToolCreator.() -> Unit) {
        ToolCreator().apply(func)
    }

    inner class ToolCreator : DSL<ToolCreator>() {

        @TopLevelToolDSL
        fun defaultTrait(traitName: String) {
            material.defaultTrait = traitName
        }

        @TopLevelToolDSL
        fun head(func: HeadCreator.() -> Unit) {
            HeadCreator().apply(func)
        }

        inner class HeadCreator : DSL<HeadCreator>() {

            @NestedDSL
            fun durability(func: () -> Int) {
                material.tool.head.durability = func()
            }

            @NestedDSL
            fun attack(func: () -> Float) {
                material.tool.head.attackDamage = func()
            }

            @NestedDSL
            fun speed(func: () -> Float) {
                material.tool.head.speed = func()
            }

            @TopLevelToolDSL
            fun harvestLevel(n: Int) {
                material.tool.head.harvestLevel = n
            }

        }

        @TopLevelToolDSL
        fun handle(func: HandleCreator.() -> Unit) {
            HandleCreator().apply(func)
        }

        inner class HandleCreator : DSL<HandleCreator>() {
            @NestedDSL
            fun durability(func: () -> Int) {
                material.tool.handle.durability = func()
            }

            @NestedDSL
            fun modifier(func: () -> Float) {
                material.tool.handle.modifier = func()
            }
        }

        @TopLevelToolDSL
        fun extra(func: ExtraCreator.() -> Unit) {
            ExtraCreator().apply(func)
        }

        inner class ExtraCreator : DSL<ExtraCreator>() {
            @NestedDSL
            fun durability(func: () -> Int) {
                material.tool.extra.durability = func()
            }
        }

        @TopLevelToolDSL
        fun bow(func: BowCreator.() -> Unit) {
            BowCreator().apply(func)
        }

        inner class BowCreator : DSL<BowCreator>() {
            @NestedDSL
            fun accuracy(func: () -> Float) {
                material.tool.fletching.accuracy = func()
            }

            @NestedDSL
            fun speed(f: Float) {
                material.tool.bow.speed = 1f / f
            }

            @NestedDSL
            fun bonusDamage(func: () -> Float) {
                material.tool.bow.bonusDamage = func()
            }

            @NestedDSL
            fun range(func: () -> Float) {
                material.tool.bow.range = func()
            }

            @NestedDSL
            fun string(func: () -> Float) {
                material.tool.bowstring.modifier = func()
            }

            @NestedDSL
            fun fletchingMod(f: Float) {
                material.tool.fletching.modifier = f
            }

        }

        @TopLevelToolDSL
        fun shaft(func: ShaftCreator.() -> Unit) {
            ShaftCreator().apply(func)
        }

        inner class ShaftCreator : DSL<ShaftCreator>() {
            @NestedDSL
            fun modifier(func: () -> Float) {
                material.tool.arrowShaft.modifier = func()
            }

            @NestedDSL
            fun bonusAmmo(func: () -> Int) {
                material.tool.arrowShaft.bonusAmmo = func()
            }
        }
    }




    @TopLevelToolDSL
    fun armor(func: ArmorCreator.() -> Unit) {
        material.armor = ArmorStats()
        ArmorCreator().apply(func)
    }

    @TopLevelToolDSL
    inner class ArmorCreator : DSL<ArmorCreator>() {

        @NestedDSL
        fun core(func: CoreCreator.() -> Unit) {
            CoreCreator().apply(func)
        }

        @NestedDSL
        fun plates(func: PlatesCreator.() -> Unit) {
            PlatesCreator().apply(func)
        }

        @NestedDSL
        fun trim(func: TrimCreator.() -> Unit) {
            TrimCreator().apply(func)
        }

        inner class CoreCreator : DSL<CoreCreator>() {
            @NestedDSL
            fun durability(func: () -> Float) {
                material.armor!!.core.durability = func()
            }

            @NestedDSL
            fun defense(func: () -> Float) {
                material.armor!!.core.defense = func()
            }
        }

        inner class PlatesCreator : DSL<PlatesCreator>() {
            @NestedDSL
            fun durability(func: () -> Float) {
                material.armor!!.plates.durability = func()
            }

            @NestedDSL
            fun modifier(func: () -> Float) {
                material.armor!!.plates.modifier = func()
            }

            @NestedDSL
            fun toughness(func: () -> Float) {
                material.armor!!.plates.toughness = func()
            }
        }

        inner class TrimCreator : DSL<TrimCreator>() {
            @NestedDSL
            fun extraDurability(func: () -> Float) {
                material.armor!!.trim.extraDurability = func()
            }
        }



    }


}
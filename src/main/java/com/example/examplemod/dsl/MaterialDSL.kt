package com.example.examplemod.dsl

import com.example.examplemod.ext.toItemStack

open class MaterialDSL(initName: String, initColor: String, initFunc: MaterialDSL.() -> Unit) : DSL<MaterialDSL>() {

    var tool = MaterialStats()

    init {
        tool.color = initColor
        tool.name = initName
        apply(initFunc)
    }

    @DslMarker
    annotation class TopLevelToolDSL

    @DslMarker
    annotation class NestedDSL

    @TopLevelToolDSL
    fun locale(vararg pairs: Pair<String, String>) {
        tool.nameLocales = pairs.toMap().toMutableMap()
    }

    @TopLevelToolDSL
    fun parts(vararg someParts: MaterialStats.MatPart) {
        someParts.forEach { tool.matParts.add(it) }
    }

    fun ingots(vararg ing: String) {
        // Add all ingots to map
        tool.smelting["ingot"]!!.addAll(ing)
        // Set icon to first ingot if no icon exists yet
        if (tool.smelting["ingot"]!!.isNotEmpty()) {
            val foundName = tool.smelting["ingot"]!!.first()
            val found = foundName.toItemStack
            if (found != null) {
                //matIngot = found
            } else {
                throw Exception("This item does NOT exist at this time!: $foundName")
            }
        }
    }

    @TopLevelToolDSL
    fun forge(func: () -> Boolean) {
        tool.madeInToolForge = func()
    }

    @TopLevelToolDSL
    fun craft(func: () -> Boolean) {
        tool.craftable = func()
    }


    @TopLevelToolDSL
    fun head(func: HeadCreator.() -> Unit) {
        HeadCreator().apply(func)
    }

    inner class HeadCreator : DSL<HeadCreator>() {

        @NestedDSL
        fun durability(func: () -> Int) {
            tool.durability = func()
        }

        @NestedDSL
        fun attack(func: () -> Int) {
            tool.toolAttackDamage = func()
        }

        @NestedDSL
        fun speed(func: () -> Float) {
            tool.toolSpeed = func()
        }
    }

    @TopLevelToolDSL
    fun handle(func: HandleCreator.() -> Unit) {
        HandleCreator().apply(func)
    }

    inner class HandleCreator : DSL<HandleCreator>() {
        @NestedDSL
        fun durability(func: () -> Int) {
            tool.handleDurability = func()
        }

        @NestedDSL
        fun mult(func: () -> Float) {
            tool.handleMult = func()
        }
    }

    @TopLevelToolDSL
    fun extra(func: ExtraCreator.() -> Unit) {
        ExtraCreator().apply(func)
    }

    inner class ExtraCreator : DSL<ExtraCreator>() {
        @NestedDSL
        fun durability(func: () -> Int) {
            tool.extraDurability = func()
        }
    }

    @TopLevelToolDSL
    fun bow(func: BowCreator.() -> Unit) {
        BowCreator().apply(func)
    }

    inner class BowCreator : DSL<BowCreator>() {
        @NestedDSL
        fun accuracy(func: () -> Float) {
            tool.bowAccuracy = func()
        }

        @NestedDSL
        fun bonusDamage(func: () -> Float) {
            tool.bowBonusDamage = func()
        }

        @NestedDSL
        fun range(func: () -> Float) {
            tool.bowRange = func()
        }

        @NestedDSL
        fun string(func: () -> Float) {
            tool.stringModifier = func()
        }
    }

    @TopLevelToolDSL
    fun shaft(func: ShaftCreator.() -> Unit) {
        ShaftCreator().apply(func)
    }

    inner class ShaftCreator : DSL<ShaftCreator>() {
        @NestedDSL
        fun modifier(func: () -> Float) {
            tool.arrowShaftModifier = func()
        }

        @NestedDSL
        fun bonusAmmo(func: () -> Int) {
            tool.arrowShaftBonusAmmo = func()
        }
    }


}
package com.ejektaflex.pewter.dsl

import com.ejektaflex.pewter.logic.MaterialStats

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

    @TopLevelToolDSL
    fun meltsAt(n: Int) {
        tool.meltingTemperature = n
    }

    @TopLevelToolDSL
    fun shininess(f: Float) {
        tool.looks["shininess"] = f
    }

    @TopLevelToolDSL
    fun defaultMetalParts() {
        // No fletching or bowstring
        val metalParts = arrayOf(
                MaterialStats.MatPart.HEAD,
                MaterialStats.MatPart.HANDLE,
                MaterialStats.MatPart.EXTRA,
                MaterialStats.MatPart.BOW,
                MaterialStats.MatPart.PROJECTILE
        )
        parts(*metalParts)
    }

    @TopLevelToolDSL
    fun harvestLevel(n: Int) {
        tool.toolHarvestLevel = n
    }

    @TopLevelToolDSL
    fun defaultTrait(traitName: String) {
        tool.defaultTrait = traitName
    }

    @TopLevelToolDSL
    fun traitList(vararg pairs: Pair<String, String>) {
        for (pair in pairs) {
            if (pair.first.toUpperCase() in MaterialStats.MatPart.values().map { it.toString() }) {
                // Add specific trait key if it doesn't exist
                if (pair.first !in tool.specificTraits.keys) {
                    tool.specificTraits[pair.first] = mutableListOf()
                }
                tool.specificTraits[pair.first]!!.add(pair.second)
            }
        }
    }

    @TopLevelToolDSL
    fun ingots(vararg ing: String) {
        // Add all ingots to map
        tool.smelting["ingot"]!!.addAll(ing)
    }

    @TopLevelToolDSL
    fun blocks(vararg blo: String) {
        tool.smelting["block"]!!.addAll(blo)
    }

    @TopLevelToolDSL
    fun nuggets(vararg blo: String) {
        tool.smelting["nugget"]!!.addAll(blo)
    }

    @TopLevelToolDSL
    fun ores(vararg blo: String) {
        tool.smelting["ore"]!!.addAll(blo)
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
        fun attack(func: () -> Float) {
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
        fun modifier(func: () -> Float) {
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
            tool.bindingDurability = func()
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
        fun speed(f: Float) {
            tool.bowSpeed = f
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
            tool.bowStringModifier = func()
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
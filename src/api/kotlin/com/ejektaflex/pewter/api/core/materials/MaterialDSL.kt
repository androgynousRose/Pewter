package com.ejektaflex.pewter.api.core.materials

import com.ejektaflex.pewter.api.core.materials.stats.ArmorStats
import com.ejektaflex.pewter.api.core.materials.stats.MaterialData
import com.ejektaflex.pewter.api.core.materials.stats.SmeltingStats

/**
 * A Kotlin DSL that describes a Tinkers' Construct Material. Used as a proxy
 * for configuring materials more easily.
 */
@Suppress("LeakingThis")
abstract class MaterialDSL(initName: String, initColor: String, initFunc: MaterialDSL.() -> Unit) : DSL<MaterialDSL>() {

    /**
     * The underlying data that is being changed by the DSL
     */
    val material = MaterialData()

    init {
        material.isCustomMaterial = false
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

    /**
     * Used to determine which [parts][MaterialData.MatPart] can be
     * created with this material.
     * @param someParts The part types that will be registered for use
     */
    @TopLevelToolDSL
    fun parts(vararg someParts: MaterialData.MatPart) {
        someParts.forEach { material.matParts.add(it) }
    }

    /**
     * Disables melting recipes for this material.
     */
    @TopLevelToolDSL
    fun noMeltRecipes() {
        material.createMeltingRecipes = false
    }

    /**
     * Determines a custom melting point for the material.
     */
    @TopLevelToolDSL
    fun meltsAt(n: Int) {
        material.meltingTemperature = n
    }

    /**
     * Determines the brightness of the autogenerated material texture
     */
    @TopLevelToolDSL
    fun brightness(f: Float) {
        material.looks.brightness = f
    }

    /**
     * Determines the shininess (contrast) of the auto-gen material texture
     */
    @TopLevelToolDSL
    fun shininess(f: Float) {
        material.looks.shininess = f
    }

    /**
     * Adds the parts that can be used to the defaults available for a
     * standard metal tool.
     */
    @TopLevelToolDSL
    fun defaultMetalParts() {
        // No fletching or bowstring
        val metalParts = arrayOf(
                MaterialData.MatPart.HEAD,
                MaterialData.MatPart.HANDLE,
                MaterialData.MatPart.EXTRA,
                MaterialData.MatPart.BOW,
                MaterialData.MatPart.PROJECTILE,
                // Armor
                MaterialData.MatPart.CORE,
                MaterialData.MatPart.PLATES,
                MaterialData.MatPart.TRIM
        )
        parts(*metalParts)
    }

    /**
     * Adds all armor parts to the list of parts that can be made from this
     * material.
     */
    @TopLevelToolDSL
    fun armorParts() {
        parts(MaterialData.MatPart.CORE, MaterialData.MatPart.PLATES, MaterialData.MatPart.TRIM)
    }

    /**
     * Adds a trait to a certain tool part. The first section of the pair is
     * the name of the [MaterialData.MatPart], and the second section is the
     * trait identifier.
     */
    @TopLevelToolDSL
    fun addTraits(vararg pairs: Pair<String, String>) {
        for (pair in pairs) {
            if (pair.first.toUpperCase() in MaterialData.MatPart.values().map { it.toString() }) {
                // Add specific trait key if it doesn't exist
                if (pair.first !in material.specificTraits.keys) {
                    material.specificTraits[pair.first] = mutableListOf()
                }
                material.specificTraits[pair.first]!!.add(pair.second)
            }
        }
    }

    /**
     * Allows the material to be created from some items, worth roughly the
     * same as an ingot.
     */
    @TopLevelToolDSL
    fun ingots(vararg ing: String) {
        // Add all ingots to map
        material.smeltingItems.ingot.addAll(ing)
    }

    @TopLevelToolDSL
    fun ingotTags(vararg ing: String) {
        material.smeltingTags.ingot.addAll(ing)
    }

    @TopLevelToolDSL
    fun blocks(vararg blo: String) {
        material.smeltingItems.block.addAll(blo)
    }

    @TopLevelToolDSL
    fun blockTags(vararg blo: String) {
        material.smeltingTags.block.addAll(blo)
    }

    @TopLevelToolDSL
    fun nuggets(vararg blo: String) {
        material.smeltingItems.nugget.addAll(blo)
    }

    @TopLevelToolDSL
    fun nuggetTags(vararg nug: String) {
        material.smeltingTags.nugget.addAll(nug)
    }

    @TopLevelToolDSL
    fun ores(vararg blo: String) {
        material.smeltingItems.ore.addAll(blo)
    }

    @TopLevelToolDSL
    fun oreTags(vararg ore: String) {
        material.smeltingTags.ore.addAll(ore)
    }

    @TopLevelToolDSL
    fun allSuffixes(vararg suffixes: String) {
        material.oreDictSuffixes.addAll(suffixes)
    }

    @TopLevelToolDSL
    fun fluids(vararg flu: String) {
        if (material.fluidNames == null) {
            material.fluidNames = mutableListOf()
        }
        material.fluidNames?.addAll(flu)
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
        fun toolTrait(traitName: String) {
            for (part in material.matParts.filter { it.partType == MaterialData.PartType.TOOL }) {
                addTraits(part.name to traitName)
            }
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

        @TopLevelToolDSL
        fun armorTrait(traitName: String) {
            for (part in material.matParts.filter { it.partType == MaterialData.PartType.ARMOR }) {
                addTraits(part.name to traitName)
            }
        }

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
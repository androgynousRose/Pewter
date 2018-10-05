[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.materials](../index.md) / [MaterialDSL](./index.md)

# MaterialDSL

`abstract class MaterialDSL : `[`DSL`](../-d-s-l/index.md)`<`[`MaterialDSL`](./index.md)`>`

### Types

| Name | Summary |
|---|---|
| [ArmorCreator](-armor-creator/index.md) | `inner class ArmorCreator : `[`DSL`](../-d-s-l/index.md)`<`[`ArmorCreator`](-armor-creator/index.md)`>` |
| [ToolCreator](-tool-creator/index.md) | `inner class ToolCreator : `[`DSL`](../-d-s-l/index.md)`<`[`ToolCreator`](-tool-creator/index.md)`>` |

### Annotations

| Name | Summary |
|---|---|
| [NestedDSL](-nested-d-s-l/index.md) | `annotation class NestedDSL` |
| [TopLevelToolDSL](-top-level-tool-d-s-l/index.md) | `annotation class TopLevelToolDSL` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaterialDSL(initName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, initColor: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, initFunc: `[`MaterialDSL`](./index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [material](material.md) | `val material: `[`MaterialData`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addTraits](add-traits.md) | `fun addTraits(vararg pairs: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [allTags](all-tags.md) | `fun allTags(vararg tags: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [armor](armor.md) | `fun armor(func: `[`ArmorCreator`](-armor-creator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [armorParts](armor-parts.md) | `fun armorParts(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [blockTags](block-tags.md) | `fun blockTags(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [blocks](blocks.md) | `fun blocks(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [brightness](brightness.md) | `fun brightness(f: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [craft](craft.md) | `fun craft(func: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultMetalParts](default-metal-parts.md) | `fun defaultMetalParts(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [fluids](fluids.md) | `fun fluids(vararg flu: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [forge](forge.md) | `fun forge(func: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ingotTags](ingot-tags.md) | `fun ingotTags(vararg ing: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ingots](ingots.md) | `fun ingots(vararg ing: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [locale](locale.md) | `fun locale(vararg pairs: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [meltsAt](melts-at.md) | `fun meltsAt(n: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [noMeltRecipes](no-melt-recipes.md) | `fun noMeltRecipes(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [nuggetTags](nugget-tags.md) | `fun nuggetTags(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [nuggets](nuggets.md) | `fun nuggets(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `fun oreTags(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [ores](ores.md) | `fun ores(vararg blo: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [parts](parts.md) | `fun parts(vararg someParts: `[`MatPart`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/-mat-part/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [shininess](shininess.md) | `fun shininess(f: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tool](tool.md) | `fun tool(func: `[`ToolCreator`](-tool-creator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [MaterialAlchemicalBrass](../../com.ejektaflex.pewter.mods.unused/-material-alchemical-brass/index.md) | `class MaterialAlchemicalBrass : `[`MaterialDSL`](./index.md) |
| [MaterialAntimony](../../com.ejektaflex.pewter.mods.soot/-material-antimony/index.md) | `class MaterialAntimony : `[`MaterialDSL`](./index.md) |
| [MaterialAshenFabric](../../com.ejektaflex.pewter.mods.embers/-material-ashen-fabric/index.md) | `class MaterialAshenFabric : `[`MaterialDSL`](./index.md) |
| [MaterialDawnstone](../../com.ejektaflex.pewter.mods.embers/-material-dawnstone/index.md) | `class MaterialDawnstone : `[`MaterialDSL`](./index.md) |
| [MaterialDragonfly](../../com.ejektaflex.pewter.mods.thebetweenlands.material/-material-dragonfly/index.md) | `class MaterialDragonfly : `[`MaterialDSL`](./index.md) |
| [MaterialElementium](../../com.ejektaflex.pewter.mods.botania.material/-material-elementium/index.md) | `class MaterialElementium : `[`MaterialDSL`](./index.md) |
| [MaterialExample](../../com.ejektaflex.pewter.mods.unused/-material-example/index.md) | `class MaterialExample : `[`MaterialDSL`](./index.md) |
| [MaterialHellfire](../../com.ejektaflex.pewter.mods.betterwithmods/-material-hellfire/index.md) | `class MaterialHellfire : `[`MaterialDSL`](./index.md) |
| [MaterialLivingrock](../../com.ejektaflex.pewter.mods.botania.material/-material-livingrock/index.md) | `class MaterialLivingrock : `[`MaterialDSL`](./index.md) |
| [MaterialLivingwood](../../com.ejektaflex.pewter.mods.botania.material/-material-livingwood/index.md) | `class MaterialLivingwood : `[`MaterialDSL`](./index.md) |
| [MaterialManasteel](../../com.ejektaflex.pewter.mods.botania.material/-material-manasteel/index.md) | `class MaterialManasteel : `[`MaterialDSL`](./index.md) |
| [MaterialManastring](../../com.ejektaflex.pewter.mods.botania.material/-material-manastring/index.md) | `class MaterialManastring : `[`MaterialDSL`](./index.md) |
| [MaterialOctine](../../com.ejektaflex.pewter.mods.thebetweenlands.material/-material-octine/index.md) | `class MaterialOctine : `[`MaterialDSL`](./index.md) |
| [MaterialSoulforgedSteel](../../com.ejektaflex.pewter.mods.betterwithmods/-material-soulforged-steel/index.md) | `class MaterialSoulforgedSteel : `[`MaterialDSL`](./index.md) |
| [MaterialStarmetal](../../com.ejektaflex.pewter.mods.astralsorcery/-material-starmetal/index.md) | `class MaterialStarmetal : `[`MaterialDSL`](./index.md) |
| [MaterialSyrmorite](../../com.ejektaflex.pewter.mods.thebetweenlands.material/-material-syrmorite/index.md) | `class MaterialSyrmorite : `[`MaterialDSL`](./index.md) |
| [MaterialTerrasteel](../../com.ejektaflex.pewter.mods.botania.material/-material-terrasteel/index.md) | `class MaterialTerrasteel : `[`MaterialDSL`](./index.md) |
| [MaterialThaumium](../../com.ejektaflex.pewter.mods.thaumcraft.material/-material-thaumium/index.md) | `class MaterialThaumium : `[`MaterialDSL`](./index.md) |
| [MaterialValonite](../../com.ejektaflex.pewter.mods.thebetweenlands.material/-material-valonite/index.md) | `class MaterialValonite : `[`MaterialDSL`](./index.md) |
| [MaterialVoidMetal](../../com.ejektaflex.pewter.mods.thaumcraft.material/-material-void-metal/index.md) | `class MaterialVoidMetal : `[`MaterialDSL`](./index.md) |
| [MaterialWeedwood](../../com.ejektaflex.pewter.mods.thebetweenlands.material/-material-weedwood/index.md) | `class MaterialWeedwood : `[`MaterialDSL`](./index.md) |

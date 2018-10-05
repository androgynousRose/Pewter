[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.materials.stats](../index.md) / [MaterialData](./index.md)

# MaterialData

`class MaterialData`

### Types

| Name | Summary |
|---|---|
| [MatPart](-mat-part/index.md) | `enum class MatPart` |
| [PartType](-part-type/index.md) | `enum class PartType` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaterialData()` |

### Properties

| Name | Summary |
|---|---|
| [armor](armor.md) | `var armor: `[`ArmorStats`](../-armor-stats/index.md)`?` |
| [color](color.md) | `var color: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [craftable](craftable.md) | `var craftable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [createMeltingRecipes](create-melting-recipes.md) | `var createMeltingRecipes: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [fluid](fluid.md) | `var fluid: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [fluidNames](fluid-names.md) | `var fluidNames: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [isCustomMaterial](is-custom-material.md) | `var isCustomMaterial: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [looks](looks.md) | `var looks: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>` |
| [madeInToolForge](made-in-tool-forge.md) | `var madeInToolForge: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [matParts](mat-parts.md) | `var matParts: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`MatPart`](-mat-part/index.md)`>` |
| [meltingTemperature](melting-temperature.md) | `var meltingTemperature: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [name](name.md) | `var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [nameLocales](name-locales.md) | `var nameLocales: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [smeltingItems](smelting-items.md) | `var smeltingItems: `[`SmeltingStats`](../-smelting-stats/index.md) |
| [smeltingTags](smelting-tags.md) | `var smeltingTags: `[`SmeltingStats`](../-smelting-stats/index.md) |
| [specificTraits](specific-traits.md) | `var specificTraits: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>` |
| [tool](tool.md) | `var tool: `[`ToolStats`](../-tool-stats/index.md) |

### Functions

| Name | Summary |
|---|---|
| [registerStats](register-stats.md) | `fun registerStats(m: Material, part: `[`MatPart`](-mat-part/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

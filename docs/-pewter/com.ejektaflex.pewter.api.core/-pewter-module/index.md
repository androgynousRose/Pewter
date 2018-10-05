[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core](../index.md) / [PewterModule](./index.md)

# PewterModule

`abstract class PewterModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterModule()` |

### Properties

| Name | Summary |
|---|---|
| [armorModifiers](armor-modifiers.md) | `open val armorModifiers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../-effect-wrapper/index.md)`<out `[`IPewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-armor-modifier.md)`>>` |
| [armorTraits](armor-traits.md) | `open val armorTraits: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../-effect-wrapper/index.md)`<out `[`IPewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-armor-trait.md)`>>` |
| [id](id.md) | `abstract val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A unique identifier for the module. May be used in the future to query the API for modules; Currently unused. |
| [materials](materials.md) | `open val materials: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`>` |
| [toolModifiers](tool-modifiers.md) | `open val toolModifiers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../-effect-wrapper/index.md)`<out `[`IPewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-tool-modifier.md)`>>` |
| [toolTraits](tool-traits.md) | `open val toolTraits: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../-effect-wrapper/index.md)`<out `[`IPewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-tool-trait.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [hasMetDependencies](has-met-dependencies.md) | `open fun hasMetDependencies(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Here you can define the conditions that determine whether or not the module should load. |

### Inheritors

| Name | Summary |
|---|---|
| [ModuleAstralSorcery](../../com.ejektaflex.pewter.modules/-module-astral-sorcery/index.md) | `class ModuleAstralSorcery : `[`PewterModule`](./index.md) |
| [ModuleBetterWithMods](../../com.ejektaflex.pewter.modules/-module-better-with-mods/index.md) | `class ModuleBetterWithMods : `[`PewterModule`](./index.md) |
| [ModuleBotania](../../com.ejektaflex.pewter.modules/-module-botania/index.md) | `class ModuleBotania : `[`PewterModule`](./index.md) |
| [ModuleCommonGems](../../com.ejektaflex.pewter.modules.common/-module-common-gems/index.md) | `class ModuleCommonGems : `[`PewterModule`](./index.md) |
| [ModuleEmbersRekindled](../../com.ejektaflex.pewter.modules/-module-embers-rekindled/index.md) | `class ModuleEmbersRekindled : `[`PewterModule`](./index.md) |
| [ModuleSoot](../../com.ejektaflex.pewter.modules/-module-soot/index.md) | `class ModuleSoot : `[`PewterModule`](./index.md) |
| [ModuleThaumcraft](../../com.ejektaflex.pewter.modules/-module-thaumcraft/index.md) | `class ModuleThaumcraft : `[`PewterModule`](./index.md) |
| [ModuleTheBetweenlands](../../com.ejektaflex.pewter.modules/-module-the-betweenlands/index.md) | `class ModuleTheBetweenlands : `[`PewterModule`](./index.md) |
| [ModuleUnused](../../com.ejektaflex.pewter.modules.other/-module-unused/index.md) | `class ModuleUnused : `[`PewterModule`](./index.md) |

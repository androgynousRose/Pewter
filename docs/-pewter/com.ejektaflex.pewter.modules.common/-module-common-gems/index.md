[Pewter](../../index.md) / [com.ejektaflex.pewter.modules.common](../index.md) / [ModuleCommonGems](./index.md)

# ModuleCommonGems

`class ModuleCommonGems : `[`PewterModule`](../../com.ejektaflex.pewter.api.core/-pewter-module/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ModuleCommonGems()` |

### Properties

| Name | Summary |
|---|---|
| [armorModifiers](armor-modifiers.md) | `val armorModifiers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-armor-modifier.md)`>>` |
| [id](id.md) | `val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A unique identifier for the module. May be used in the future to query the API for modules; Currently unused. |
| [toolModifiers](tool-modifiers.md) | `val toolModifiers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-tool-modifier.md)`>>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [armorTraits](../../com.ejektaflex.pewter.api.core/-pewter-module/armor-traits.md) | `open val armorTraits: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-armor-trait.md)`>>` |
| [materials](../../com.ejektaflex.pewter.api.core/-pewter-module/materials.md) | `open val materials: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`>` |
| [toolTraits](../../com.ejektaflex.pewter.api.core/-pewter-module/tool-traits.md) | `open val toolTraits: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-tool-trait.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [hasMetDependencies](has-met-dependencies.md) | `fun hasMetDependencies(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Here you can define the conditions that determine whether or not the module should load. |

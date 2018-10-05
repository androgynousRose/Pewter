[Pewter](../../index.md) / [com.ejektaflex.pewter.lib](../index.md) / [AbstractLoadable](./index.md)

# AbstractLoadable

`abstract class AbstractLoadable<M, D>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractLoadable()` |

### Properties

| Name | Summary |
|---|---|
| [content](content.md) | `var content: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`M`](index.md#M)`>` |
| [internalContent](internal-content.md) | `open val internalContent: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`D`](index.md#D)`>` |
| [isLoaded](is-loaded.md) | `var isLoaded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `abstract operator fun get(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`M`](index.md#M)`?`<br>Allows querying for a content object |
| [iterator](iterator.md) | `operator fun iterator(): `[`Iterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)`<`[`M`](index.md#M)`>`<br>Allows iterating over a content object |
| [setup](setup.md) | `fun setup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [transformContent](transform-content.md) | `abstract fun transformContent(items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`D`](index.md#D)`>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`M`](index.md#M)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [PewterMaterials](../../com.ejektaflex.pewter.content/-pewter-materials/index.md) | `object PewterMaterials : `[`AbstractLoadable`](./index.md)`<`[`MaterialRegistrar`](../../com.ejektaflex.pewter.logic/-material-registrar/index.md)`, `[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`>` |
| [PewterModifiers](../../com.ejektaflex.pewter.content/-pewter-modifiers/index.md) | `object PewterModifiers : `[`AbstractLoadable`](./index.md)`<`[`IPewterModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-modifier/index.md)`, `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-modifier/index.md)`>>` |
| [PewterTraits](../../com.ejektaflex.pewter.content/-pewter-traits/index.md) | `object PewterTraits : `[`AbstractLoadable`](./index.md)`<`[`IPewterTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-trait.md)`, `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-trait.md)`>>` |

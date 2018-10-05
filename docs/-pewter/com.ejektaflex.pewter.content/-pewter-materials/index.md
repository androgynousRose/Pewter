[Pewter](../../index.md) / [com.ejektaflex.pewter.content](../index.md) / [PewterMaterials](./index.md)

# PewterMaterials

`object PewterMaterials : `[`AbstractLoadable`](../../com.ejektaflex.pewter.lib/-abstract-loadable/index.md)`<`[`MaterialRegistrar`](../../com.ejektaflex.pewter.logic/-material-registrar/index.md)`, `[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`>`

### Inherited Properties

| Name | Summary |
|---|---|
| [content](../../com.ejektaflex.pewter.lib/-abstract-loadable/content.md) | `var content: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`M`](../../com.ejektaflex.pewter.lib/-abstract-loadable/index.md#M)`>` |
| [internalContent](../../com.ejektaflex.pewter.lib/-abstract-loadable/internal-content.md) | `open val internalContent: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`D`](../../com.ejektaflex.pewter.lib/-abstract-loadable/index.md#D)`>` |
| [isLoaded](../../com.ejektaflex.pewter.lib/-abstract-loadable/is-loaded.md) | `var isLoaded: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `fun get(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MaterialRegistrar`](../../com.ejektaflex.pewter.logic/-material-registrar/index.md)`?`<br>Allows querying for a content object |
| [transformContent](transform-content.md) | `fun transformContent(items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaterialRegistrar`](../../com.ejektaflex.pewter.logic/-material-registrar/index.md)`>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [iterator](../../com.ejektaflex.pewter.lib/-abstract-loadable/iterator.md) | `operator fun iterator(): `[`Iterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)`<`[`M`](../../com.ejektaflex.pewter.lib/-abstract-loadable/index.md#M)`>`<br>Allows iterating over a content object |
| [setup](../../com.ejektaflex.pewter.lib/-abstract-loadable/setup.md) | `fun setup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

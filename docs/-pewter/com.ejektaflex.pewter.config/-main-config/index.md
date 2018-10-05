[Pewter](../../index.md) / [com.ejektaflex.pewter.config](../index.md) / [MainConfig](./index.md)

# MainConfig

`open class MainConfig : `[`KConfig`](../-k-config/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainConfig(folder: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [blacklistedMaterials](blacklisted-materials.md) | `var blacklistedMaterials: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [blacklistedModifiers](blacklisted-modifiers.md) | `var blacklistedModifiers: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [conarmIntegration](conarm-integration.md) | `open var conarmIntegration: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadExternalContent](load-external-content.md) | `open var loadExternalContent: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadPewter](load-pewter.md) | `open var loadPewter: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [config](../-k-config/config.md) | `var config: Configuration` |

### Functions

| Name | Summary |
|---|---|
| [grab](grab.md) | `fun grab(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [hasChanged](../-k-config/has-changed.md) | `open fun hasChanged(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [load](../-k-config/load.md) | `open fun load(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](../-k-config/save.md) | `open fun save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

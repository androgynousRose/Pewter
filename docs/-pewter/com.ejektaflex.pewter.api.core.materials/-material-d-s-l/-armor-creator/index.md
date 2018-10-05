[Pewter](../../../index.md) / [com.ejektaflex.pewter.api.core.materials](../../index.md) / [MaterialDSL](../index.md) / [ArmorCreator](./index.md)

# ArmorCreator

`inner class ArmorCreator : `[`DSL`](../../-d-s-l/index.md)`<`[`ArmorCreator`](./index.md)`>`

### Types

| Name | Summary |
|---|---|
| [CoreCreator](-core-creator/index.md) | `inner class CoreCreator : `[`DSL`](../../-d-s-l/index.md)`<`[`CoreCreator`](-core-creator/index.md)`>` |
| [PlatesCreator](-plates-creator/index.md) | `inner class PlatesCreator : `[`DSL`](../../-d-s-l/index.md)`<`[`PlatesCreator`](-plates-creator/index.md)`>` |
| [TrimCreator](-trim-creator/index.md) | `inner class TrimCreator : `[`DSL`](../../-d-s-l/index.md)`<`[`TrimCreator`](-trim-creator/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorCreator()` |

### Functions

| Name | Summary |
|---|---|
| [armorTrait](armor-trait.md) | `fun armorTrait(traitName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [core](core.md) | `fun core(func: `[`CoreCreator`](-core-creator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [plates](plates.md) | `fun plates(func: `[`PlatesCreator`](-plates-creator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [trim](trim.md) | `fun trim(func: `[`TrimCreator`](-trim-creator/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

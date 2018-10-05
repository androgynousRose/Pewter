[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.methods](../index.md) / [EntityBonus](./index.md)

# EntityBonus

`interface EntityBonus<N : `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`>`

### Properties

| Name | Summary |
|---|---|
| [bonusInterfaces](bonus-interfaces.md) | `abstract val bonusInterfaces: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [calculateEntityBonus](calculate-entity-bonus.md) | `abstract fun calculateEntityBonus(e: EntityLivingBase, original: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, func: EntityLivingBase.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`N`](index.md#N) |

### Inheritors

| Name | Summary |
|---|---|
| [ToolTraitCorrosive](../../com.ejektaflex.pewter.mods.thebetweenlands.tool/-tool-trait-corrosive/index.md) | `class ToolTraitCorrosive : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`EntityBonus`](./index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |

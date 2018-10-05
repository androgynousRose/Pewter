[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.modifiers](../index.md) / [IPewterModifier](./index.md)

# IPewterModifier

`interface IPewterModifier : `[`IPewterBaseEffect`](../../com.ejektaflex.pewter.api.core/-i-pewter-base-effect.md)

### Functions

| Name | Summary |
|---|---|
| [configure](configure.md) | `abstract fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItemsSafe](get-items-safe.md) | `abstract fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [safeAdd](safe-add.md) | `abstract fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [IPewterArmorModifier](../-i-pewter-armor-modifier.md) | `interface IPewterArmorModifier : `[`IPewterModifier`](./index.md) |
| [IPewterToolModifier](../-i-pewter-tool-modifier.md) | `interface IPewterToolModifier : `[`IPewterModifier`](./index.md) |

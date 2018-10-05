[Pewter](../index.md) / [com.ejektaflex.pewter.api.core.modifiers](index.md) / [IPewterArmorModifier](./-i-pewter-armor-modifier.md)

# IPewterArmorModifier

`interface IPewterArmorModifier : `[`IPewterModifier`](-i-pewter-modifier/index.md)

### Inherited Functions

| Name | Summary |
|---|---|
| [configure](-i-pewter-modifier/configure.md) | `abstract fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItemsSafe](-i-pewter-modifier/get-items-safe.md) | `abstract fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [safeAdd](-i-pewter-modifier/safe-add.md) | `abstract fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [PewterArmorModifier](-pewter-armor-modifier/index.md) | `abstract class PewterArmorModifier : ArmorModifierTrait, `[`IPewterArmorModifier`](./-i-pewter-armor-modifier.md)<br>Extend this if you want to create a new armor modifier. |

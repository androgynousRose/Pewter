[Pewter](../../index.md) / [com.ejektaflex.pewter.lib.mixins](../index.md) / [ManaExchanger](./index.md)

# ManaExchanger

`interface ManaExchanger`

### Functions

| Name | Summary |
|---|---|
| [drainManaFor](drain-mana-for.md) | `open fun drainManaFor(item: ItemStack, player: EntityPlayer, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasEnoughMana](has-enough-mana.md) | `open fun hasEnoughMana(item: ItemStack, player: EntityPlayer, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorTraitAdapting](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-adapting/index.md) | `class ArmorTraitAdapting : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`ManaExchanger`](./index.md) |
| [ArmorTraitTerra](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-terra/index.md) | `class ArmorTraitTerra : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`ManaExchanger`](./index.md)`, `[`TinkerNBTHelper`](../-tinker-n-b-t-helper/index.md) |
| [IModManaInfused](../../com.ejektaflex.pewter.shared.methods/-i-mod-mana-infused/index.md) | `interface IModManaInfused : `[`SharedTrait`](../../com.ejektaflex.pewter.lib.traits/-shared-trait.md)`, `[`ManaExchanger`](./index.md)`, `[`TinkerNBTHelper`](../-tinker-n-b-t-helper/index.md)`, `[`IModChange`](../../com.ejektaflex.pewter.shared.methods/-i-mod-change/index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |

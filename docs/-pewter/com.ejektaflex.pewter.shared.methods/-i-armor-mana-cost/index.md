[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.methods](../index.md) / [IArmorManaCost](./index.md)

# IArmorManaCost

`interface IArmorManaCost : `[`IModChange`](../-i-mod-change/index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`

### Properties

| Name | Summary |
|---|---|
| [baseChange](base-change.md) | `open val baseChange: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [modCost](mod-cost.md) | `open fun modCost(item: ItemStack?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModRuneMana](../../com.ejektaflex.pewter.mods.botania.armor/-armor-mod-rune-mana/index.md) | `class ArmorModRuneMana : `[`PewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IArmorManaCost`](./index.md) |
| [ArmorTraitManaInfused](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-mana-infused/index.md) | `class ArmorTraitManaInfused : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`IModManaInfused`](../-i-mod-mana-infused/index.md)`, `[`IArmorManaCost`](./index.md) |

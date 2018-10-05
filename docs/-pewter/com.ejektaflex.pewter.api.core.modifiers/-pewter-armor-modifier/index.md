[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.modifiers](../index.md) / [PewterArmorModifier](./index.md)

# PewterArmorModifier

`abstract class PewterArmorModifier : ArmorModifierTrait, `[`IPewterArmorModifier`](../-i-pewter-armor-modifier.md)

Extend this if you want to create a new armor modifier.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterArmorModifier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, countPerLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = name.toLowerCase().filter { it != ' ' })`<br>Extend this if you want to create a new armor modifier. |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getItemsSafe](get-items-safe.md) | `open fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [safeAdd](safe-add.md) | `open fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModAquaStarseeker](../../com.ejektaflex.pewter.mods.astralsorcery/-armor-mod-aqua-starseeker/index.md) | `class ArmorModAquaStarseeker : `[`PewterArmorModifier`](./index.md)`, `[`IModAquaNight`](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/index.md)`, `[`IModChange`](../../com.ejektaflex.pewter.shared.methods/-i-mod-change/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, IModifierDisplay` |
| [ArmorModDragonstone](../../com.ejektaflex.pewter.mods.botania.armor/-armor-mod-dragonstone/index.md) | `class ArmorModDragonstone : `[`PewterArmorModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ArmorModRuneMana](../../com.ejektaflex.pewter.mods.botania.armor/-armor-mod-rune-mana/index.md) | `class ArmorModRuneMana : `[`PewterArmorModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IArmorManaCost`](../../com.ejektaflex.pewter.shared.methods/-i-armor-mana-cost/index.md) |
| [GemArmorModifier](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md) | `abstract class GemArmorModifier : `[`PewterArmorModifier`](./index.md)`, `[`IModGem`](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |

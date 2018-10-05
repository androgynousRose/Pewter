[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.modifiers](../index.md) / [PewterToolModifier](./index.md)

# PewterToolModifier

`abstract class PewterToolModifier : ModifierTrait, `[`IPewterToolModifier`](../-i-pewter-tool-modifier.md)

Extend this if you want to create a new tool modifier.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterToolModifier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, countPerLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = name.toLowerCase().filter { it != ' ' })`<br>Extend this if you want to create a new tool modifier. |

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
| [GemToolModifier](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md) | `abstract class GemToolModifier : `[`PewterToolModifier`](./index.md)`, `[`IModGem`](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolModAquaCelestial](../../com.ejektaflex.pewter.mods.astralsorcery/-tool-mod-aqua-celestial/index.md) | `class ToolModAquaCelestial : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IModChange`](../../com.ejektaflex.pewter.shared.methods/-i-mod-change/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`IModAquaNight`](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/index.md) |
| [ToolModDragonstone](../../com.ejektaflex.pewter.mods.botania.tool/-tool-mod-dragonstone/index.md) | `class ToolModDragonstone : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay` |
| [ToolModQuicksilver](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-mod-quicksilver/index.md) | `class ToolModQuicksilver : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay` |
| [ToolModRuneAutumn](../../com.ejektaflex.pewter.mods.botania.tool/-tool-mod-rune-autumn/index.md) | `class ToolModRuneAutumn : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IToolHarvestBonus`](../../com.ejektaflex.pewter.shared.methods/-i-tool-harvest-bonus/index.md) |
| [ToolModRuneMana](../../com.ejektaflex.pewter.mods.botania.tool/-tool-mod-rune-mana/index.md) | `class ToolModRuneMana : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IToolManaCost`](../../com.ejektaflex.pewter.shared.methods/-i-tool-mana-cost/index.md) |
| [ToolModSanitizing](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-mod-sanitizing/index.md) | `class ToolModSanitizing : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolModStick](../../com.ejektaflex.pewter.mods.unused/-tool-mod-stick/index.md) | `class ToolModStick : `[`PewterToolModifier`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |

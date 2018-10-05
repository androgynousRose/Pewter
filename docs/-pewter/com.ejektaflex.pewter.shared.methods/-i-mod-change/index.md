[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.methods](../index.md) / [IModChange](./index.md)

# IModChange

`interface IModChange<T>`

### Properties

| Name | Summary |
|---|---|
| [baseChange](base-change.md) | `abstract val baseChange: `[`T`](index.md#T) |

### Functions

| Name | Summary |
|---|---|
| [modCost](mod-cost.md) | `abstract fun modCost(item: ItemStack?): `[`T`](index.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModAquaStarseeker](../../com.ejektaflex.pewter.mods.astralsorcery/-armor-mod-aqua-starseeker/index.md) | `class ArmorModAquaStarseeker : `[`PewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/index.md)`, `[`IModAquaNight`](../-i-mod-aqua-night/index.md)`, `[`IModChange`](./index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, IModifierDisplay` |
| [IArmorManaCost](../-i-armor-mana-cost/index.md) | `interface IArmorManaCost : `[`IModChange`](./index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [IModManaInfused](../-i-mod-mana-infused/index.md) | `interface IModManaInfused : `[`SharedTrait`](../../com.ejektaflex.pewter.lib.traits/-shared-trait.md)`, `[`ManaExchanger`](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, `[`IModChange`](./index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [IToolHarvestBonus](../-i-tool-harvest-bonus/index.md) | `interface IToolHarvestBonus : `[`IModChange`](./index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [IToolManaCost](../-i-tool-mana-cost/index.md) | `interface IToolManaCost : `[`IModChange`](./index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [ToolModAquaCelestial](../../com.ejektaflex.pewter.mods.astralsorcery/-tool-mod-aqua-celestial/index.md) | `class ToolModAquaCelestial : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IModChange`](./index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`IModAquaNight`](../-i-mod-aqua-night/index.md) |

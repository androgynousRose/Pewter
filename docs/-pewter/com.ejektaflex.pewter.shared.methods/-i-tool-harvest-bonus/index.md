[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.methods](../index.md) / [IToolHarvestBonus](./index.md)

# IToolHarvestBonus

`interface IToolHarvestBonus : `[`IModChange`](../-i-mod-change/index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`

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
| [ToolModRuneAutumn](../../com.ejektaflex.pewter.mods.botania.tool/-tool-mod-rune-autumn/index.md) | `class ToolModRuneAutumn : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IToolHarvestBonus`](./index.md) |
| [ToolTraitManaHarvest](../../com.ejektaflex.pewter.mods.botania.tool/-tool-trait-mana-harvest/index.md) | `class ToolTraitManaHarvest : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`IToolHarvestBonus`](./index.md) |

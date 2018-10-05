[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.botania.tool](../index.md) / [ToolTraitManaHarvest](./index.md)

# ToolTraitManaHarvest

`class ToolTraitManaHarvest : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`IToolHarvestBonus`](../../com.ejektaflex.pewter.shared.methods/-i-tool-harvest-bonus/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolTraitManaHarvest(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [baseChange](../../com.ejektaflex.pewter.shared.methods/-i-tool-harvest-bonus/base-change.md) | `open val baseChange: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [damage](damage.md) | `fun damage(tool: ItemStack?, player: EntityLivingBase, target: EntityLivingBase, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseStatsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [modCost](../../com.ejektaflex.pewter.shared.methods/-i-tool-harvest-bonus/mod-cost.md) | `open fun modCost(item: ItemStack?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [statsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

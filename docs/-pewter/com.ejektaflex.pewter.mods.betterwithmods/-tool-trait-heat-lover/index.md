[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.betterwithmods](../index.md) / [ToolTraitHeatLover](./index.md)

# ToolTraitHeatLover

`class ToolTraitHeatLover : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`IModHeatLover`](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolTraitHeatLover(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onHit](on-hit.md) | `fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseStatsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [calcHealAmount](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/calc-heal-amount.md) | `open fun calcHealAmount(target: EntityLivingBase, random: `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [statsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

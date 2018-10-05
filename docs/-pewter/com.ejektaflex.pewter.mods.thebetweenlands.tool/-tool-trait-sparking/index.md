[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.thebetweenlands.tool](../index.md) / [ToolTraitSparking](./index.md)

# ToolTraitSparking

`class ToolTraitSparking : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolTraitSparking(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [damage](damage.md) | `fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [onHit](on-hit.md) | `fun onHit(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseStatsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [statsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [BURNING_BONUS_DAMAGE](-b-u-r-n-i-n-g_-b-o-n-u-s_-d-a-m-a-g-e.md) | `const val BURNING_BONUS_DAMAGE: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [BURNING_LENGTH](-b-u-r-n-i-n-g_-l-e-n-g-t-h.md) | `const val BURNING_LENGTH: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [CHANCE](-c-h-a-n-c-e.md) | `const val CHANCE: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

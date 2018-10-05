[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.thaumcraft.tool](../index.md) / [ToolTraitEssentia](./index.md)

# ToolTraitEssentia

`class ToolTraitEssentia : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolTraitEssentia(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [blockHarvestDrops](block-harvest-drops.md) | `fun blockHarvestDrops(tool: ItemStack, event: HarvestDropsEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onHit](on-hit.md) | `fun onHit(tool: ItemStack, player: EntityLivingBase, target: EntityLivingBase, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addFluxFor](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/add-flux-for.md) | `open fun addFluxFor(e: EntityLivingBase, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun addFluxFor(e: BlockEvent, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [baseStatsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [drainVisFor](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/drain-vis-for.md) | `open fun drainVisFor(e: EntityLivingBase, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getFluxAt](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/get-flux-at.md) | `open fun getFluxAt(e: EntityLivingBase): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getVisAt](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/get-vis-at.md) | `open fun getVisAt(e: EntityLivingBase): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [statsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [blockChance](block-chance.md) | `const val blockChance: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [entityChance](entity-chance.md) | `const val entityChance: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

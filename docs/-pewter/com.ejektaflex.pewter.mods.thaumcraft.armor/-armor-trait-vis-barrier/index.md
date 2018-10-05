[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.thaumcraft.armor](../index.md) / [ArmorTraitVisBarrier](./index.md)

# ArmorTraitVisBarrier

`class ArmorTraitVisBarrier : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorTraitVisBarrier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onDamaged](on-damaged.md) | `fun onDamaged(armor: ItemStack?, player: EntityPlayer, source: DamageSource, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, evt: LivingDamageEvent?): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addFluxFor](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/add-flux-for.md) | `open fun addFluxFor(e: EntityLivingBase, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun addFluxFor(e: BlockEvent, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [armorSetOriginalStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-original-stats.md) | `fun armorSetOriginalStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [armorSetStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-stats.md) | `fun armorSetStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [drainVisFor](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/drain-vis-for.md) | `open fun drainVisFor(e: EntityLivingBase, amount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getFluxAt](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/get-flux-at.md) | `open fun getFluxAt(e: EntityLivingBase): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getVisAt](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/get-vis-at.md) | `open fun getVisAt(e: EntityLivingBase): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DRAIN_AMOUNT](-d-r-a-i-n_-a-m-o-u-n-t.md) | `const val DRAIN_AMOUNT: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [DRAIN_CHANCE](-d-r-a-i-n_-c-h-a-n-c-e.md) | `const val DRAIN_CHANCE: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [REPAIR_AMOUNT](-r-e-p-a-i-r_-a-m-o-u-n-t.md) | `const val REPAIR_AMOUNT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.betterwithmods](../index.md) / [ArmorTraitHeatLover](./index.md)

# ArmorTraitHeatLover

`class ArmorTraitHeatLover : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`IModHeatLover`](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorTraitHeatLover(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onDamaged](on-damaged.md) | `fun onDamaged(armor: ItemStack?, player: EntityPlayer?, source: DamageSource, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, evt: LivingDamageEvent?): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [armorSetOriginalStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-original-stats.md) | `fun armorSetOriginalStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [armorSetStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-stats.md) | `fun armorSetStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [calcHealAmount](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/calc-heal-amount.md) | `open fun calcHealAmount(target: EntityLivingBase, random: `[`Random`](http://docs.oracle.com/javase/6/docs/api/java/util/Random.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

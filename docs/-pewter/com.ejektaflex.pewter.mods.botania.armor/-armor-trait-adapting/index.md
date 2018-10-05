[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.botania.armor](../index.md) / [ArmorTraitAdapting](./index.md)

# ArmorTraitAdapting

`class ArmorTraitAdapting : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`ManaExchanger`](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorTraitAdapting(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getModifications](get-modifications.md) | `fun getModifications(player: EntityPlayer?, mods: ArmorModifications, armor: ItemStack?, source: DamageSource?, damage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): ArmorModifications` |

### Inherited Functions

| Name | Summary |
|---|---|
| [armorSetOriginalStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-original-stats.md) | `fun armorSetOriginalStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [armorSetStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-stats.md) | `fun armorSetStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [drainManaFor](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/drain-mana-for.md) | `open fun drainManaFor(item: ItemStack, player: EntityPlayer, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasEnoughMana](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/has-enough-mana.md) | `open fun hasEnoughMana(item: ItemStack, player: EntityPlayer, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [MANA_COST](-m-a-n-a_-c-o-s-t.md) | `const val MANA_COST: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

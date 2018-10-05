[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.botania.armor](../index.md) / [ArmorTraitManaInfused](./index.md)

# ArmorTraitManaInfused

`class ArmorTraitManaInfused : `[`PewterArmorTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/index.md)`, `[`IModManaInfused`](../../com.ejektaflex.pewter.shared.methods/-i-mod-mana-infused/index.md)`, `[`IArmorManaCost`](../../com.ejektaflex.pewter.shared.methods/-i-armor-mana-cost/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorTraitManaInfused(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [manaCost](mana-cost.md) | `val manaCost: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onToolDamage](on-tool-damage.md) | `fun onToolDamage(tool: ItemStack, damage: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, newDamage: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, entity: EntityLivingBase?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onUpdate](on-update.md) | `fun onUpdate(tool: ItemStack, world: World, entity: Entity?, itemSlot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, isSelected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [armorSetOriginalStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-original-stats.md) | `fun armorSetOriginalStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [armorSetStats](../../com.ejektaflex.pewter.api.core.traits/-pewter-armor-trait/armor-set-stats.md) | `fun armorSetStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |

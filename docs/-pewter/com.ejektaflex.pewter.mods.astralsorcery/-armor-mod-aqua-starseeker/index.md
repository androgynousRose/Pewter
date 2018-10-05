[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.astralsorcery](../index.md) / [ArmorModAquaStarseeker](./index.md)

# ArmorModAquaStarseeker

`class ArmorModAquaStarseeker : `[`PewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/index.md)`, `[`IModAquaNight`](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/index.md)`, `[`IModChange`](../../com.ejektaflex.pewter.shared.methods/-i-mod-change/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, IModifierDisplay`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArmorModAquaStarseeker(modName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [baseChange](base-change.md) | `val baseChange: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [configure](configure.md) | `fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getExtraInfo](get-extra-info.md) | `fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [getModifications](get-modifications.md) | `fun getModifications(player: EntityPlayer?, mods: ArmorModifications?, armor: ItemStack?, source: DamageSource?, damage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): ArmorModifications` |
| [modCost](mod-cost.md) | `fun modCost(item: ItemStack?): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getItemsSafe](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/get-items-safe.md) | `open fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [isRightSetting](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/is-right-setting.md) | `open fun isRightSetting(player: EntityLivingBase): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [safeAdd](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/safe-add.md) | `open fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

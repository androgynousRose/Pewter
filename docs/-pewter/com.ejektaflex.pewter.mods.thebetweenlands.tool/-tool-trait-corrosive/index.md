[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.thebetweenlands.tool](../index.md) / [ToolTraitCorrosive](./index.md)

# ToolTraitCorrosive

`class ToolTraitCorrosive : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`EntityBonus`](../../com.ejektaflex.pewter.shared.methods/-entity-bonus/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolTraitCorrosive(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [bonusInterfaces](bonus-interfaces.md) | `val bonusInterfaces: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [calculateEntityBonus](calculate-entity-bonus.md) | `fun calculateEntityBonus(e: EntityLivingBase, original: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, func: EntityLivingBase.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [damage](damage.md) | `fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [onRepair](on-repair.md) | `fun onRepair(tool: ItemStack?, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onUpdate](on-update.md) | `fun onUpdate(tool: ItemStack, world: World, entity: Entity, itemSlot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, isSelected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tooltip](tooltip.md) | `fun tooltip(event: ItemTooltipEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseMaterialNames](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-material-names.md) | `open fun baseMaterialNames(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>`open fun baseMaterialNames(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [baseMaterials](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-materials.md) | `open fun baseMaterials(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>`<br>`open fun baseMaterials(item: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>` |
| [baseStatsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [getTraits](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/get-traits.md) | `open fun getTraits(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<IModifier>` |
| [hasTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tag.md) | `open fun hasTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasToolTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tool-tag.md) | `open fun hasToolTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [modifyArmorStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-armor-stats.md) | `open fun modifyArmorStats(armor: ItemStack, func: (original: ArmorNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyArmorStats(root: NBTTagCompound, func: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyModifierTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-modifier-tag.md) | `open fun modifyModifierTag(root: NBTTagCompound, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyModifierTag(item: ItemStack, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyToolStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-tool-stats.md) | `open fun modifyToolStats(tool: ItemStack, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [statsOf](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [ATTACK_BONUS](-a-t-t-a-c-k_-b-o-n-u-s.md) | `const val ATTACK_BONUS: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [CHANCE](-c-h-a-n-c-e.md) | `const val CHANCE: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [CORROSION_TAG](-c-o-r-r-o-s-i-o-n_-t-a-g.md) | `const val CORROSION_TAG: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [MIN_ATTACK_PERCENT](-m-i-n_-a-t-t-a-c-k_-p-e-r-c-e-n-t.md) | `const val MIN_ATTACK_PERCENT: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.astralsorcery](../index.md) / [ToolModAquaCelestial](./index.md)

# ToolModAquaCelestial

`class ToolModAquaCelestial : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IModChange`](../../com.ejektaflex.pewter.shared.methods/-i-mod-change/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`IModAquaNight`](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolModAquaCelestial(modName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [baseChange](base-change.md) | `val baseChange: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [configure](configure.md) | `fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [damage](damage.md) | `fun damage(tool: ItemStack?, player: EntityLivingBase?, target: EntityLivingBase?, damage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, newDamage: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, isCritical: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getExtraInfo](get-extra-info.md) | `fun getExtraInfo(tool: ItemStack?, modifierTag: NBTTagCompound?): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [modCost](mod-cost.md) | `fun modCost(item: ItemStack?): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [onUpdate](on-update.md) | `fun onUpdate(tool: ItemStack?, world: World?, entity: Entity?, itemSlot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, isSelected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseMaterialNames](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-material-names.md) | `open fun baseMaterialNames(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>`open fun baseMaterialNames(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [baseMaterials](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-materials.md) | `open fun baseMaterials(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>`<br>`open fun baseMaterials(item: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>` |
| [getItemsSafe](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/get-items-safe.md) | `open fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [getTraits](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/get-traits.md) | `open fun getTraits(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<IModifier>` |
| [hasTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tag.md) | `open fun hasTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasToolTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tool-tag.md) | `open fun hasToolTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isRightSetting](../../com.ejektaflex.pewter.shared.methods/-i-mod-aqua-night/is-right-setting.md) | `open fun isRightSetting(player: EntityLivingBase): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [modifyArmorStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-armor-stats.md) | `open fun modifyArmorStats(armor: ItemStack, func: (original: ArmorNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyArmorStats(root: NBTTagCompound, func: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyModifierTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-modifier-tag.md) | `open fun modifyModifierTag(root: NBTTagCompound, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyModifierTag(item: ItemStack, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyToolStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-tool-stats.md) | `open fun modifyToolStats(tool: ItemStack, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [safeAdd](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/safe-add.md) | `open fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [elevationBonusMax](elevation-bonus-max.md) | `const val elevationBonusMax: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

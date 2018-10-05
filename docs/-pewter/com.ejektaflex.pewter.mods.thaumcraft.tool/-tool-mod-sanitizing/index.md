[Pewter](../../index.md) / [com.ejektaflex.pewter.mods.thaumcraft.tool](../index.md) / [ToolModSanitizing](./index.md)

# ToolModSanitizing

`class ToolModSanitizing : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ToolModSanitizing(modName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [applyEffect](apply-effect.md) | `fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [canApplyCustom](can-apply-custom.md) | `fun canApplyCustom(stack: ItemStack?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [configure](configure.md) | `fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [baseMaterialNames](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-material-names.md) | `open fun baseMaterialNames(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>`open fun baseMaterialNames(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [baseMaterials](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/base-materials.md) | `open fun baseMaterials(root: NBTTagCompound): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>`<br>`open fun baseMaterials(item: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Material>` |
| [getItemsSafe](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/get-items-safe.md) | `open fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [getTraits](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/get-traits.md) | `open fun getTraits(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<IModifier>` |
| [hasTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tag.md) | `open fun hasTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasToolTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tool-tag.md) | `open fun hasToolTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [modifyArmorStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-armor-stats.md) | `open fun modifyArmorStats(armor: ItemStack, func: (original: ArmorNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyArmorStats(root: NBTTagCompound, func: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyModifierTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-modifier-tag.md) | `open fun modifyModifierTag(root: NBTTagCompound, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyModifierTag(item: ItemStack, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyToolStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-tool-stats.md) | `open fun modifyToolStats(tool: ItemStack, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [safeAdd](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/safe-add.md) | `open fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [SANITIZING_TAG](-s-a-n-i-t-i-z-i-n-g_-t-a-g.md) | `const val SANITIZING_TAG: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

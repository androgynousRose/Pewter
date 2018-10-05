[Pewter](../../index.md) / [com.ejektaflex.pewter.lib.modifiers](../index.md) / [GemToolModifier](./index.md)

# GemToolModifier

`abstract class GemToolModifier : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`IModGem`](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GemToolModifier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [armorMod](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/armor-mod.md) | `abstract val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [name](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [oreTags](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/ore-tags.md) | `abstract val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/tool-mod.md) | `abstract val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [applyEffect](apply-effect.md) | `open fun applyEffect(rootCompound: NBTTagCompound, modifierTag: NBTTagCompound?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [configure](configure.md) | `open fun configure(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

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

### Inheritors

| Name | Summary |
|---|---|
| [ToolModAmber](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-amber/index.md) | `class ToolModAmber : `[`GemToolModifier`](./index.md)`, `[`IModAmber`](../../com.ejektaflex.pewter.shared.gems/-i-mod-amber/index.md) |
| [ToolModAmethyst](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-amethyst/index.md) | `class ToolModAmethyst : `[`GemToolModifier`](./index.md)`, `[`IModAmethyst`](../../com.ejektaflex.pewter.shared.gems/-i-mod-amethyst/index.md) |
| [ToolModMalachite](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-malachite/index.md) | `class ToolModMalachite : `[`GemToolModifier`](./index.md)`, `[`IModMalachite`](../../com.ejektaflex.pewter.shared.gems/-i-mod-malachite/index.md) |
| [ToolModPeridot](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-peridot/index.md) | `class ToolModPeridot : `[`GemToolModifier`](./index.md)`, `[`IModPeridot`](../../com.ejektaflex.pewter.shared.gems/-i-mod-peridot/index.md) |
| [ToolModRuby](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-ruby/index.md) | `class ToolModRuby : `[`GemToolModifier`](./index.md)`, `[`IModRuby`](../../com.ejektaflex.pewter.shared.gems/-i-mod-ruby/index.md) |
| [ToolModSapphire](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-sapphire/index.md) | `class ToolModSapphire : `[`GemToolModifier`](./index.md)`, `[`IModSapphire`](../../com.ejektaflex.pewter.shared.gems/-i-mod-sapphire/index.md) |
| [ToolModTanzanite](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-tanzanite/index.md) | `class ToolModTanzanite : `[`GemToolModifier`](./index.md)`, `[`IModTanzanite`](../../com.ejektaflex.pewter.shared.gems/-i-mod-tanzanite/index.md) |
| [ToolModTopaz](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-topaz/index.md) | `class ToolModTopaz : `[`GemToolModifier`](./index.md)`, `[`IModTopaz`](../../com.ejektaflex.pewter.shared.gems/-i-mod-topaz/index.md) |

[Pewter](../../index.md) / [com.ejektaflex.pewter.lib.modifiers](../index.md) / [GemArmorModifier](./index.md)

# GemArmorModifier

`abstract class GemArmorModifier : `[`PewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/index.md)`, `[`IModGem`](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GemArmorModifier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [armorMod](../../com.ejektaflex.pewter.shared.gems/-i-mod-gem/armor-mod.md) | `abstract val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [name](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
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
| [getItemsSafe](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/get-items-safe.md) | `open fun getItemsSafe(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>>?` |
| [getTraits](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/get-traits.md) | `open fun getTraits(stack: ItemStack): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<IModifier>` |
| [hasTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tag.md) | `open fun hasTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasToolTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/has-tool-tag.md) | `open fun hasToolTag(tool: ItemStack, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [modifyArmorStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-armor-stats.md) | `open fun modifyArmorStats(armor: ItemStack, func: (original: ArmorNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyArmorStats(root: NBTTagCompound, func: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyModifierTag](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-modifier-tag.md) | `open fun modifyModifierTag(root: NBTTagCompound, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyModifierTag(item: ItemStack, id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: (tag: NBTTagCompound, data: IntegerNBT) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [modifyToolStats](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/modify-tool-stats.md) | `open fun modifyToolStats(tool: ItemStack, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: (original: ToolNBT, current: NBTTagCompound) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun modifyToolStats(root: NBTTagCompound, func: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [safeAdd](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/safe-add.md) | `open fun safeAdd(stack: ItemStack?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModAmber](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-amber/index.md) | `class ArmorModAmber : `[`GemArmorModifier`](./index.md)`, `[`IModAmber`](../../com.ejektaflex.pewter.shared.gems/-i-mod-amber/index.md) |
| [ArmorModAmethyst](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-amethyst/index.md) | `class ArmorModAmethyst : `[`GemArmorModifier`](./index.md)`, `[`IModAmethyst`](../../com.ejektaflex.pewter.shared.gems/-i-mod-amethyst/index.md) |
| [ArmorModMalachite](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-malachite/index.md) | `class ArmorModMalachite : `[`GemArmorModifier`](./index.md)`, `[`IModMalachite`](../../com.ejektaflex.pewter.shared.gems/-i-mod-malachite/index.md) |
| [ArmorModPeridot](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-peridot/index.md) | `class ArmorModPeridot : `[`GemArmorModifier`](./index.md)`, `[`IModPeridot`](../../com.ejektaflex.pewter.shared.gems/-i-mod-peridot/index.md) |
| [ArmorModRuby](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-ruby/index.md) | `class ArmorModRuby : `[`GemArmorModifier`](./index.md)`, `[`IModRuby`](../../com.ejektaflex.pewter.shared.gems/-i-mod-ruby/index.md) |
| [ArmorModSapphire](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-sapphire/index.md) | `class ArmorModSapphire : `[`GemArmorModifier`](./index.md)`, `[`IModSapphire`](../../com.ejektaflex.pewter.shared.gems/-i-mod-sapphire/index.md) |
| [ArmorModTanzanite](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-tanzanite/index.md) | `class ArmorModTanzanite : `[`GemArmorModifier`](./index.md)`, `[`IModTanzanite`](../../com.ejektaflex.pewter.shared.gems/-i-mod-tanzanite/index.md) |
| [ArmorModTopaz](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-topaz/index.md) | `class ArmorModTopaz : `[`GemArmorModifier`](./index.md)`, `[`IModTopaz`](../../com.ejektaflex.pewter.shared.gems/-i-mod-topaz/index.md) |

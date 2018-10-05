[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.gems](../index.md) / [IModPeridot](./index.md)

# IModPeridot

`interface IModPeridot : `[`IModGem`](../-i-mod-gem/index.md)

### Properties

| Name | Summary |
|---|---|
| [armorMod](armor-mod.md) | `open val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `open val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](tool-mod.md) | `open val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModPeridot](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-peridot/index.md) | `class ArmorModPeridot : `[`GemArmorModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md)`, `[`IModPeridot`](./index.md) |
| [ToolModPeridot](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-peridot/index.md) | `class ToolModPeridot : `[`GemToolModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md)`, `[`IModPeridot`](./index.md) |

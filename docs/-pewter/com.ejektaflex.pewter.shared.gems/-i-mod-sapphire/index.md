[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.gems](../index.md) / [IModSapphire](./index.md)

# IModSapphire

`interface IModSapphire : `[`IModGem`](../-i-mod-gem/index.md)

### Properties

| Name | Summary |
|---|---|
| [armorMod](armor-mod.md) | `open val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `open val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](tool-mod.md) | `open val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModSapphire](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-sapphire/index.md) | `class ArmorModSapphire : `[`GemArmorModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md)`, `[`IModSapphire`](./index.md) |
| [ToolModSapphire](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-sapphire/index.md) | `class ToolModSapphire : `[`GemToolModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md)`, `[`IModSapphire`](./index.md) |

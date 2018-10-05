[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.gems](../index.md) / [IModRuby](./index.md)

# IModRuby

`interface IModRuby : `[`IModGem`](../-i-mod-gem/index.md)

### Properties

| Name | Summary |
|---|---|
| [armorMod](armor-mod.md) | `open val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `open val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](tool-mod.md) | `open val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModRuby](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-ruby/index.md) | `class ArmorModRuby : `[`GemArmorModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md)`, `[`IModRuby`](./index.md) |
| [ToolModRuby](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-ruby/index.md) | `class ToolModRuby : `[`GemToolModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md)`, `[`IModRuby`](./index.md) |

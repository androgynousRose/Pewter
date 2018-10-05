[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.gems](../index.md) / [IModAmethyst](./index.md)

# IModAmethyst

`interface IModAmethyst : `[`IModGem`](../-i-mod-gem/index.md)

### Properties

| Name | Summary |
|---|---|
| [armorMod](armor-mod.md) | `open val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `open val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](tool-mod.md) | `open val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorModAmethyst](../../com.ejektaflex.pewter.mods.commongems.armor/-armor-mod-amethyst/index.md) | `class ArmorModAmethyst : `[`GemArmorModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md)`, `[`IModAmethyst`](./index.md) |
| [ToolModAmethyst](../../com.ejektaflex.pewter.mods.commongems.tool/-tool-mod-amethyst/index.md) | `class ToolModAmethyst : `[`GemToolModifier`](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md)`, `[`IModAmethyst`](./index.md) |

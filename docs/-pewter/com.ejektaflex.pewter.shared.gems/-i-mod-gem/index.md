[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.gems](../index.md) / [IModGem](./index.md)

# IModGem

`interface IModGem`

### Properties

| Name | Summary |
|---|---|
| [armorMod](armor-mod.md) | `abstract val armorMod: ArmorNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [oreTags](ore-tags.md) | `abstract val oreTags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [toolMod](tool-mod.md) | `abstract val toolMod: ToolNBT.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [GemArmorModifier](../../com.ejektaflex.pewter.lib.modifiers/-gem-armor-modifier/index.md) | `abstract class GemArmorModifier : `[`PewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-armor-modifier/index.md)`, `[`IModGem`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [GemToolModifier](../../com.ejektaflex.pewter.lib.modifiers/-gem-tool-modifier/index.md) | `abstract class GemToolModifier : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`IModGem`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [IModAmber](../-i-mod-amber/index.md) | `interface IModAmber : `[`IModGem`](./index.md) |
| [IModAmethyst](../-i-mod-amethyst/index.md) | `interface IModAmethyst : `[`IModGem`](./index.md) |
| [IModMalachite](../-i-mod-malachite/index.md) | `interface IModMalachite : `[`IModGem`](./index.md) |
| [IModPeridot](../-i-mod-peridot/index.md) | `interface IModPeridot : `[`IModGem`](./index.md) |
| [IModRuby](../-i-mod-ruby/index.md) | `interface IModRuby : `[`IModGem`](./index.md) |
| [IModSapphire](../-i-mod-sapphire/index.md) | `interface IModSapphire : `[`IModGem`](./index.md) |
| [IModTanzanite](../-i-mod-tanzanite/index.md) | `interface IModTanzanite : `[`IModGem`](./index.md) |
| [IModTopaz](../-i-mod-topaz/index.md) | `interface IModTopaz : `[`IModGem`](./index.md) |

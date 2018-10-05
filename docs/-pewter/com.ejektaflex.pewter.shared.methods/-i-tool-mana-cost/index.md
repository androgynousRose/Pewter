[Pewter](../../index.md) / [com.ejektaflex.pewter.shared.methods](../index.md) / [IToolManaCost](./index.md)

# IToolManaCost

`interface IToolManaCost : `[`IModChange`](../-i-mod-change/index.md)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`

### Properties

| Name | Summary |
|---|---|
| [baseChange](base-change.md) | `open val baseChange: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [modCost](mod-cost.md) | `open fun modCost(item: ItemStack?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ToolModRuneMana](../../com.ejektaflex.pewter.mods.botania.tool/-tool-mod-rune-mana/index.md) | `class ToolModRuneMana : `[`PewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-pewter-tool-modifier/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md)`, IModifierDisplay, `[`IToolManaCost`](./index.md) |
| [ToolTraitManaInfused](../../com.ejektaflex.pewter.mods.botania.tool/-tool-trait-mana-infused/index.md) | `class ToolTraitManaInfused : `[`PewterToolTrait`](../../com.ejektaflex.pewter.api.core.traits/-pewter-tool-trait/index.md)`, `[`IModManaInfused`](../-i-mod-mana-infused/index.md)`, `[`IToolManaCost`](./index.md) |

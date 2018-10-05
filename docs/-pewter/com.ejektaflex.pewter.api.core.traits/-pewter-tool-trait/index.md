[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.traits](../index.md) / [PewterToolTrait](./index.md)

# PewterToolTrait

`abstract class PewterToolTrait : ModifierTrait, `[`IPewterToolTrait`](../-i-pewter-tool-trait.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterToolTrait(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = name.toLowerCase().filter { it != ' ' })` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [baseStatsOf](base-stats-of.md) | `fun baseStatsOf(tool: ItemStack?): ToolNBT` |
| [statsOf](stats-of.md) | `fun statsOf(tool: ItemStack?): ToolNBT` |

### Inheritors

| Name | Summary |
|---|---|
| [ToolTraitAttuned](../../com.ejektaflex.pewter.mods.unused/-tool-trait-attuned/index.md) | `class ToolTraitAttuned : `[`PewterToolTrait`](./index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md) |
| [ToolTraitAural](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-trait-aural/index.md) | `class ToolTraitAural : `[`PewterToolTrait`](./index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md) |
| [ToolTraitBasher](../../com.ejektaflex.pewter.mods.unused/-tool-trait-basher/index.md) | `class ToolTraitBasher : `[`PewterToolTrait`](./index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md) |
| [ToolTraitBrilliance](../../com.ejektaflex.pewter.mods.astralsorcery/-tool-trait-brilliance/index.md) | `class ToolTraitBrilliance : `[`PewterToolTrait`](./index.md) |
| [ToolTraitCorrosive](../../com.ejektaflex.pewter.mods.thebetweenlands.tool/-tool-trait-corrosive/index.md) | `class ToolTraitCorrosive : `[`PewterToolTrait`](./index.md)`, `[`EntityBonus`](../../com.ejektaflex.pewter.shared.methods/-entity-bonus/index.md)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolTraitDawn](../../com.ejektaflex.pewter.mods.embers/-tool-trait-dawn/index.md) | `class ToolTraitDawn : `[`PewterToolTrait`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolTraitEssentia](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-trait-essentia/index.md) | `class ToolTraitEssentia : `[`PewterToolTrait`](./index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md) |
| [ToolTraitGritty](../../com.ejektaflex.pewter.mods.thebetweenlands.tool/-tool-trait-gritty/index.md) | `class ToolTraitGritty : `[`PewterToolTrait`](./index.md) |
| [ToolTraitHeatLover](../../com.ejektaflex.pewter.mods.betterwithmods/-tool-trait-heat-lover/index.md) | `class ToolTraitHeatLover : `[`PewterToolTrait`](./index.md)`, `[`IModHeatLover`](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/index.md) |
| [ToolTraitHeavyweight](../../com.ejektaflex.pewter.mods.unused/-tool-trait-heavyweight/index.md) | `class ToolTraitHeavyweight : `[`PewterToolTrait`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolTraitKindler](../../com.ejektaflex.pewter.mods.unused/-tool-trait-kindler/index.md) | `class ToolTraitKindler : `[`PewterToolTrait`](./index.md)`, `[`IModHeatLover`](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/index.md) |
| [ToolTraitManaHarvest](../../com.ejektaflex.pewter.mods.botania.tool/-tool-trait-mana-harvest/index.md) | `class ToolTraitManaHarvest : `[`PewterToolTrait`](./index.md)`, `[`IToolHarvestBonus`](../../com.ejektaflex.pewter.shared.methods/-i-tool-harvest-bonus/index.md) |
| [ToolTraitManaInfused](../../com.ejektaflex.pewter.mods.botania.tool/-tool-trait-mana-infused/index.md) | `class ToolTraitManaInfused : `[`PewterToolTrait`](./index.md)`, `[`IModManaInfused`](../../com.ejektaflex.pewter.shared.methods/-i-mod-mana-infused/index.md)`, `[`IToolManaCost`](../../com.ejektaflex.pewter.shared.methods/-i-tool-mana-cost/index.md) |
| [ToolTraitPolluted](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-trait-polluted/index.md) | `class ToolTraitPolluted : `[`PewterToolTrait`](./index.md) |
| [ToolTraitQuenching](../../com.ejektaflex.pewter.mods.soot/-tool-trait-quenching/index.md) | `class ToolTraitQuenching : `[`PewterToolTrait`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ToolTraitSapping](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-trait-sapping/index.md) | `class ToolTraitSapping : `[`PewterToolTrait`](./index.md) |
| [ToolTraitSimmering](../../com.ejektaflex.pewter.mods.embers/-tool-trait-simmering/index.md) | `class ToolTraitSimmering : `[`PewterToolTrait`](./index.md) |
| [ToolTraitSparking](../../com.ejektaflex.pewter.mods.thebetweenlands.tool/-tool-trait-sparking/index.md) | `class ToolTraitSparking : `[`PewterToolTrait`](./index.md) |
| [ToolTraitWarping](../../com.ejektaflex.pewter.mods.thaumcraft.tool/-tool-trait-warping/index.md) | `class ToolTraitWarping : `[`PewterToolTrait`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |

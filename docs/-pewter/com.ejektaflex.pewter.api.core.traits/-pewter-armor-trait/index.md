[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core.traits](../index.md) / [PewterArmorTrait](./index.md)

# PewterArmorTrait

`open class PewterArmorTrait : AbstractArmorTrait, `[`IPewterArmorTrait`](../-i-pewter-armor-trait.md)

Extend this if you want to create a new Armor trait.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterArmorTrait(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = name.toLowerCase().filter { it != ' ' })`<br>Extend this if you want to create a new Armor trait. |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [armorSetOriginalStats](armor-set-original-stats.md) | `fun armorSetOriginalStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |
| [armorSetStats](armor-set-stats.md) | `fun armorSetStats(entity: EntityPlayer): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ArmorNBT>` |

### Inheritors

| Name | Summary |
|---|---|
| [ArmorTraitAdapting](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-adapting/index.md) | `class ArmorTraitAdapting : `[`PewterArmorTrait`](./index.md)`, `[`ManaExchanger`](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/index.md) |
| [ArmorTraitAshwoven](../../com.ejektaflex.pewter.mods.embers/-armor-trait-ashwoven/index.md) | `class ArmorTraitAshwoven : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitBranded](../../com.ejektaflex.pewter.mods.embers/-armor-trait-branded/index.md) | `class ArmorTraitBranded : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitCorrosive](../../com.ejektaflex.pewter.mods.thebetweenlands.armor/-armor-trait-corrosive/index.md) | `class ArmorTraitCorrosive : `[`PewterArmorTrait`](./index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ArmorTraitEnvious](../../com.ejektaflex.pewter.mods.betterwithmods/-armor-trait-envious/index.md) | `class ArmorTraitEnvious : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitExperimental](../../com.ejektaflex.pewter.mods.unused/-armor-trait-experimental/index.md) | `class ArmorTraitExperimental : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitHeatLover](../../com.ejektaflex.pewter.mods.betterwithmods/-armor-trait-heat-lover/index.md) | `class ArmorTraitHeatLover : `[`PewterArmorTrait`](./index.md)`, `[`IModHeatLover`](../../com.ejektaflex.pewter.shared.methods/-i-mod-heat-lover/index.md) |
| [ArmorTraitInflamed](../../com.ejektaflex.pewter.mods.unused/-armor-trait-inflamed/index.md) | `class ArmorTraitInflamed : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitManaInfused](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-mana-infused/index.md) | `class ArmorTraitManaInfused : `[`PewterArmorTrait`](./index.md)`, `[`IModManaInfused`](../../com.ejektaflex.pewter.shared.methods/-i-mod-mana-infused/index.md)`, `[`IArmorManaCost`](../../com.ejektaflex.pewter.shared.methods/-i-armor-mana-cost/index.md) |
| [ArmorTraitManiacal](../../com.ejektaflex.pewter.mods.thaumcraft.armor/-armor-trait-maniacal/index.md) | `class ArmorTraitManiacal : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitSplash](../../com.ejektaflex.pewter.mods.thebetweenlands.armor/-armor-trait-splash/index.md) | `class ArmorTraitSplash : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitSquelching](../../com.ejektaflex.pewter.mods.soot/-armor-trait-squelching/index.md) | `class ArmorTraitSquelching : `[`PewterArmorTrait`](./index.md) |
| [ArmorTraitTerra](../../com.ejektaflex.pewter.mods.botania.armor/-armor-trait-terra/index.md) | `class ArmorTraitTerra : `[`PewterArmorTrait`](./index.md)`, `[`ManaExchanger`](../../com.ejektaflex.pewter.lib.mixins/-mana-exchanger/index.md)`, `[`TinkerNBTHelper`](../../com.ejektaflex.pewter.lib.mixins/-tinker-n-b-t-helper/index.md) |
| [ArmorTraitVisBarrier](../../com.ejektaflex.pewter.mods.thaumcraft.armor/-armor-trait-vis-barrier/index.md) | `class ArmorTraitVisBarrier : `[`PewterArmorTrait`](./index.md)`, `[`AuraExchanger`](../../com.ejektaflex.pewter.lib.mixins/-aura-exchanger/index.md) |

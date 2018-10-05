[Pewter](../index.md) / [com.ejektaflex.pewter.ext](./index.md)

## Package com.ejektaflex.pewter.ext

### Types

| Name | Summary |
|---|---|
| [NBTMap](-n-b-t-map/index.md) | `enum class NBTMap` |
| [NBTMapping](-n-b-t-mapping/index.md) | `object NBTMapping` |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.util.Random](java.util.-random/index.md) |  |
| [kotlin.String](kotlin.-string/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |
| [kotlin.ranges.ClosedRange](kotlin.ranges.-closed-range/index.md) |  |
| [net.minecraft.command.ICommandSender](net.minecraft.command.-i-command-sender/index.md) |  |
| [net.minecraft.entity.EntityLivingBase](net.minecraft.entity.-entity-living-base/index.md) |  |
| [net.minecraft.entity.player.EntityPlayer](net.minecraft.entity.player.-entity-player/index.md) |  |
| [net.minecraft.entity.player.InventoryPlayer](net.minecraft.entity.player.-inventory-player/index.md) |  |
| [net.minecraft.item.Item](net.minecraft.item.-item/index.md) |  |
| [net.minecraft.item.ItemStack](net.minecraft.item.-item-stack/index.md) |  |
| [net.minecraft.nbt.NBTTagCompound](net.minecraft.nbt.-n-b-t-tag-compound/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [getPewterModifier](get-pewter-modifier.md) | `fun <T : Modifier> getPewterModifier(): `[`IPewterModifier`](../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-modifier/index.md) |
| [getPewterTrait](get-pewter-trait.md) | `fun <T : `[`MaterialRegistrar`](../com.ejektaflex.pewter.logic/-material-registrar/index.md)`> getPewterTrait(): `[`IPewterTrait`](../com.ejektaflex.pewter.api.core.traits/-i-pewter-trait.md) |
| [getTinkersMaterial](get-tinkers-material.md) | `fun <T : Material> getTinkersMaterial(): Material` |
| [getTinkersModifier](get-tinkers-modifier.md) | `fun <T : Modifier> getTinkersModifier(): IModifier`<br>`fun getTinkersModifier(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): IModifier` |
| [getTinkersModifiers](get-tinkers-modifiers.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getTinkersModifiers(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](get-tinkers-modifiers.md#T)`>` |
| [isAtMaxDurability](is-at-max-durability.md) | `fun isAtMaxDurability(tool: ItemStack): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [nonRemote](non-remote.md) | `fun nonRemote(world: World, func: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun <T> nonRemote(world: World, default: `[`T`](non-remote.md#T)`, func: () -> `[`T`](non-remote.md#T)`): `[`T`](non-remote.md#T) |

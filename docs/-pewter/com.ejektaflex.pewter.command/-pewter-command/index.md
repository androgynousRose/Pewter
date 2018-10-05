[Pewter](../../index.md) / [com.ejektaflex.pewter.command](../index.md) / [PewterCommand](./index.md)

# PewterCommand

`class PewterCommand : ICommand`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterCommand()` |

### Functions

| Name | Summary |
|---|---|
| [checkPermission](check-permission.md) | `fun checkPermission(server: MinecraftServer, sender: ICommandSender): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [compareTo](compare-to.md) | `fun compareTo(other: ICommand): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [execute](execute.md) | `fun execute(server: MinecraftServer, sender: ICommandSender, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAliases](get-aliases.md) | `fun getAliases(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getTabCompletions](get-tab-completions.md) | `fun getTabCompletions(server: MinecraftServer, sender: ICommandSender, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, pos: BlockPos?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [getUsage](get-usage.md) | `fun getUsage(sender: ICommandSender): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isUsernameIndex](is-username-index.md) | `fun isUsernameIndex(args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

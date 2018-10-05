[Pewter](../../index.md) / [com.ejektaflex.pewter.api.core](../index.md) / [EffectWrapper](./index.md)

# EffectWrapper

`class EffectWrapper<T : `[`IPewterBaseEffect`](../-i-pewter-base-effect.md)`>`

This is a simple wrapper around an effect that allows you to store a
reference to an effect without instantiating it. This is needed because
these effects get registered into registries when they're instantiated.
Multiple instantiations of a tool effect will then cause an error due
to how they're implemented in TiC/ConArm.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `EffectWrapper(identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, func: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`.() -> `[`T`](index.md#T)`)`<br>This is a simple wrapper around an effect that allows you to store a reference to an effect without instantiating it. This is needed because these effects get registered into registries when they're instantiated. Multiple instantiations of a tool effect will then cause an error due to how they're implemented in TiC/ConArm. |

### Properties

| Name | Summary |
|---|---|
| [func](func.md) | `val func: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`.() -> `[`T`](index.md#T) |
| [identifier](identifier.md) | `var identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(): `[`T`](index.md#T) |

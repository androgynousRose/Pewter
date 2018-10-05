[Pewter](../../index.md) / [com.ejektaflex.pewter](../index.md) / [Pewter](./index.md)

# Pewter

`object Pewter : `[`IProxy`](../../com.ejektaflex.pewter.proxy/-i-proxy/index.md)

### Properties

| Name | Summary |
|---|---|
| [ADAPTER](-a-d-a-p-t-e-r.md) | `const val ADAPTER: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [CONFIG](-c-o-n-f-i-g.md) | `lateinit var CONFIG: `[`Configs`](../../com.ejektaflex.pewter.config/-configs/index.md) |
| [DEPENDS](-d-e-p-e-n-d-s.md) | `const val DEPENDS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [LOGGER](-l-o-g-g-e-r.md) | `var LOGGER: Logger?` |
| [MCVERSION](-m-c-v-e-r-s-i-o-n.md) | `const val MCVERSION: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [MODID](-m-o-d-i-d.md) | `const val MODID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [NAME](-n-a-m-e.md) | `const val NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [VERSION](-v-e-r-s-i-o-n.md) | `const val VERSION: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [proxy](proxy.md) | `lateinit var proxy: `[`IProxy`](../../com.ejektaflex.pewter.proxy/-i-proxy/index.md) |

### Functions

| Name | Summary |
|---|---|
| [hasBlacklistedModifier](has-blacklisted-modifier.md) | `fun hasBlacklistedModifier(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [init](init.md) | `fun init(event: FMLInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isUsingConArm](is-using-con-arm.md) | `fun isUsingConArm(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadAPI](load-a-p-i.md) | `fun loadAPI(event: FMLConstructionEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [postInit](post-init.md) | `fun postInit(event: FMLPostInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [preInit](pre-init.md) | `fun preInit(event: FMLPreInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [serverLoad](server-load.md) | `fun serverLoad(event: FMLServerStartingEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [shouldLoadJsonContent](should-load-json-content.md) | `fun shouldLoadJsonContent(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

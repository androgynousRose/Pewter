[Pewter](../../index.md) / [com.ejektaflex.pewter.logic](../index.md) / [MaterialRegistrar](./index.md)

# MaterialRegistrar

`open class MaterialRegistrar : `[`IProxy`](../../com.ejektaflex.pewter.proxy/-i-proxy/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MaterialRegistrar(data: `[`MaterialData`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [block](block.md) | `var block: Block?` |
| [data](data.md) | `val data: `[`MaterialData`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/index.md) |
| [fluid](fluid.md) | `var fluid: Fluid?` |
| [fluidItem](fluid-item.md) | `var fluidItem: ItemBlock?` |
| [tinkMaterial](tink-material.md) | `lateinit var tinkMaterial: Material` |

### Functions

| Name | Summary |
|---|---|
| [init](init.md) | `open fun init(e: FMLInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [integrate](integrate.md) | `fun integrate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [postInit](post-init.md) | `open fun postInit(e: FMLPostInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [preInit](pre-init.md) | `open fun preInit(e: FMLPreInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

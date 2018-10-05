[Pewter](../../index.md) / [com.ejektaflex.pewter.proxy](../index.md) / [CommonProxy](./index.md)

# CommonProxy

`open class CommonProxy : `[`IProxy`](../-i-proxy/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CommonProxy()` |

### Properties

| Name | Summary |
|---|---|
| [block](block.md) | `lateinit var block: Block` |
| [fluid](fluid.md) | `lateinit var fluid: FluidMolten` |
| [item](item.md) | `lateinit var item: Item` |

### Functions

| Name | Summary |
|---|---|
| [init](init.md) | `open fun init(e: FMLInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [makePewterFluid](make-pewter-fluid.md) | `open fun makePewterFluid(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [postInit](post-init.md) | `open fun postInit(e: FMLPostInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [preInit](pre-init.md) | `open fun preInit(e: FMLPreInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ClientProxy](../-client-proxy/index.md) | `class ClientProxy : `[`CommonProxy`](./index.md) |

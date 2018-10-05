[Pewter](../../index.md) / [com.ejektaflex.pewter.proxy](../index.md) / [ClientProxy](./index.md)

# ClientProxy

`class ClientProxy : `[`CommonProxy`](../-common-proxy/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ClientProxy()` |

### Inherited Properties

| Name | Summary |
|---|---|
| [block](../-common-proxy/block.md) | `lateinit var block: Block` |
| [fluid](../-common-proxy/fluid.md) | `lateinit var fluid: FluidMolten` |
| [item](../-common-proxy/item.md) | `lateinit var item: Item` |

### Functions

| Name | Summary |
|---|---|
| [makePewterFluid](make-pewter-fluid.md) | `fun makePewterFluid(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onModelBake](on-model-bake.md) | `fun onModelBake(event: ModelBakeEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [postInit](post-init.md) | `fun postInit(e: FMLPostInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [preInit](pre-init.md) | `fun preInit(e: FMLPreInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [init](../-common-proxy/init.md) | `open fun init(e: FMLInitializationEvent): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [textureGetter](texture-getter.md) | `var textureGetter: Function<ResourceLocation, TextureAtlasSprite>` |

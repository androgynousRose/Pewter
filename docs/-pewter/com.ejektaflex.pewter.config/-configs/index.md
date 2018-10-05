[Pewter](../../index.md) / [com.ejektaflex.pewter.config](../index.md) / [Configs](./index.md)

# Configs

`object Configs`

### Properties

| Name | Summary |
|---|---|
| [DIR](-d-i-r.md) | `lateinit var DIR: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html) |
| [MAIN](-m-a-i-n.md) | `lateinit var MAIN: `[`MainConfig`](../-main-config/index.md) |
| [externalMaterials](external-materials.md) | `val externalMaterials: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MaterialData`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [generateMaterialFile](generate-material-file.md) | `fun generateMaterialFile(location: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, dsl: `[`MaterialData`](../../com.ejektaflex.pewter.api.core.materials.stats/-material-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initialize](initialize.md) | `fun initialize(root: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [load](load.md) | `fun load(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](save.md) | `fun save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

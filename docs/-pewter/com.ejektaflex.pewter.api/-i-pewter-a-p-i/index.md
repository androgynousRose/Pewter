[Pewter](../../index.md) / [com.ejektaflex.pewter.api](../index.md) / [IPewterAPI](./index.md)

# IPewterAPI

`interface IPewterAPI`

All calls to the Pewter API should be done before Pewter loads PreInit.
This is because Pewter registers which content to load in PreInit.
Make sure your mod is required before Pewter. If using Construct's Armory,
make sure your mod is required after that.

### Functions

| Name | Summary |
|---|---|
| [addArmorModifier](add-armor-modifier.md) | `open fun addArmorModifier(mod: `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterArmorModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-armor-modifier.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds an armor modifier to Pewter. |
| [addArmorRepository](add-armor-repository.md) | `open fun addArmorRepository(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a book repository location from which it can display modifiers in the book "Materials &amp; You: Armory Addendum", if it is loaded. |
| [addArmorTrait](add-armor-trait.md) | `open fun addArmorTrait(mod: `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-trait.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds an armor trait to Pewter. |
| [addMaterial](add-material.md) | `open fun addMaterial(material: `[`MaterialDSL`](../../com.ejektaflex.pewter.api.core.materials/-material-d-s-l/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a material definition to Pewter. |
| [addToolModifier](add-tool-modifier.md) | `open fun addToolModifier(mod: `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterToolModifier`](../../com.ejektaflex.pewter.api.core.modifiers/-i-pewter-tool-modifier.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a tool modifier to Pewter. |
| [addToolRepository](add-tool-repository.md) | `open fun addToolRepository(location: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a book repository location from which it can display modifiers in the book "Materials &amp; You" |
| [addToolTrait](add-tool-trait.md) | `open fun addToolTrait(mod: `[`EffectWrapper`](../../com.ejektaflex.pewter.api.core/-effect-wrapper/index.md)`<out `[`IPewterTrait`](../../com.ejektaflex.pewter.api.core.traits/-i-pewter-trait.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a tool trait to Pewter. |
| [log](log.md) | `open fun log(any: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used to log API work done by Pewter. |
| [registerModule](register-module.md) | `open fun registerModule(module: `[`PewterModule`](../../com.ejektaflex.pewter.api.core/-pewter-module/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a content module (a predefined set of materials, modifiers and traits) to Pewter. |

### Inheritors

| Name | Summary |
|---|---|
| [PewterAPIProvider](../-pewter-a-p-i-provider/index.md) | `open class PewterAPIProvider : `[`IPewterAPI`](./index.md) |

[Pewter](../index.md) / [com.ejektaflex.pewter.api](./index.md)

## Package com.ejektaflex.pewter.api

### Types

| Name | Summary |
|---|---|
| [IPewterAPI](-i-pewter-a-p-i/index.md) | `interface IPewterAPI`<br>All calls to the Pewter API should be done before Pewter loads PreInit. This is because Pewter registers which content to load in PreInit. Make sure your mod is required before Pewter. If using Construct's Armory, make sure your mod is required after that. |
| [PewterAPI](-pewter-a-p-i.md) | `object PewterAPI : `[`PewterAPIProvider`](-pewter-a-p-i-provider/index.md) |
| [PewterAPIProvider](-pewter-a-p-i-provider/index.md) | `open class PewterAPIProvider : `[`IPewterAPI`](-i-pewter-a-p-i/index.md) |

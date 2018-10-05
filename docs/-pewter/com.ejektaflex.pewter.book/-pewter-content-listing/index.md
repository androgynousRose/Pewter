[Pewter](../../index.md) / [com.ejektaflex.pewter.book](../index.md) / [PewterContentListing](./index.md)

# PewterContentListing

`abstract class PewterContentListing<C : TinkerPage> : ContentListingSectionTransformer`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterContentListing(secName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [pagesToRemove](pages-to-remove.md) | `val pagesToRemove: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<PageData>` |

### Functions

| Name | Summary |
|---|---|
| [getModItems](get-mod-items.md) | `abstract fun getModItems(mod: IModifier): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>?` |
| [getModifierFromPage](get-modifier-from-page.md) | `abstract fun getModifierFromPage(content: PageContent): IModifier?` |
| [pewterProcessPage](pewter-process-page.md) | `fun <M : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> pewterProcessPage(book: BookData, listing: ContentListing, page: PageData): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [transform](transform.md) | `open fun transform(book: BookData, data: SectionData): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [PewterArmorSectionTransformer](../-pewter-armor-section-transformer/index.md) | `class PewterArmorSectionTransformer : `[`PewterContentListing`](./index.md)`<ContentArmorModifier>` |
| [PewterToolSectionTransformer](../-pewter-tool-section-transformer/index.md) | `class PewterToolSectionTransformer : `[`PewterContentListing`](./index.md)`<ContentModifier>` |

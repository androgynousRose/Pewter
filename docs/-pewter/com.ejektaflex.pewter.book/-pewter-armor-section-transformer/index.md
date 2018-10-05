[Pewter](../../index.md) / [com.ejektaflex.pewter.book](../index.md) / [PewterArmorSectionTransformer](./index.md)

# PewterArmorSectionTransformer

`class PewterArmorSectionTransformer : `[`PewterContentListing`](../-pewter-content-listing/index.md)`<ContentArmorModifier>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PewterArmorSectionTransformer(secName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [pagesToRemove](../-pewter-content-listing/pages-to-remove.md) | `val pagesToRemove: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<PageData>` |

### Functions

| Name | Summary |
|---|---|
| [getModItems](get-mod-items.md) | `fun getModItems(mod: IModifier): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemStack>?` |
| [getModifierFromPage](get-modifier-from-page.md) | `fun getModifierFromPage(content: PageContent): IModifier?` |
| [processPage](process-page.md) | `fun processPage(book: BookData, listing: ContentListing, page: PageData): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [pewterProcessPage](../-pewter-content-listing/pewter-process-page.md) | `fun <M : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> pewterProcessPage(book: BookData, listing: ContentListing, page: PageData): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [transform](../-pewter-content-listing/transform.md) | `open fun transform(book: BookData, data: SectionData): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

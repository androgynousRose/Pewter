package com.ejektaflex.pewter.book

import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.mantle.client.book.data.SectionData
import slimeknights.mantle.client.book.data.content.PageContent
import slimeknights.tconstruct.library.book.TinkerPage
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer
import slimeknights.tconstruct.library.modifiers.IModifier

@SideOnly(Side.CLIENT)
abstract class  PewterContentListing<C : TinkerPage>(secName: String) : ContentListingSectionTransformer(secName) {

    val pagesToRemove = mutableListOf<PageData>()

    abstract fun getModItems(mod: IModifier): List<ItemStack>?

    abstract fun getModifierFromPage(content: PageContent): IModifier?

    inline fun <reified M : Any> pewterProcessPage(book: BookData, listing: ContentListing, page: PageData) {
        val modifier = getModifierFromPage(page.content)
        if (modifier != null && modifier is M) {

            val modItems = getModItems(modifier)

            if (modItems != null && modItems.isNotEmpty()) {
                listing.addEntry(modifier.localizedName, page)
            } else {
                pagesToRemove.add(page)
            }

        }
    }

    override fun transform(book: BookData, data: SectionData) {
        val listing = ContentListing()
        listing.title = book.translate(sectionName)

        val listingPage = PageData(true)
        listingPage.name = sectionName
        listingPage.source = data.source
        listingPage.parent = data
        listingPage.content = listing

        data.pages.forEach { sectionPage -> processPage(book, listing, sectionPage) }

        // Remove all pages that processing took care of
        for (page in pagesToRemove) {
            data.pages.remove(page)
        }

        if (listing.hasEntries()) {
            listingPage.load()

            data.pages.add(0, listingPage)
        }
    }

}
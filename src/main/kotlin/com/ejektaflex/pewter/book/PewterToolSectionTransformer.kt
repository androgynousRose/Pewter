package com.ejektaflex.pewter.book

import com.ejektaflex.pewter.lib.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.mantle.client.book.data.SectionData
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.book.content.ContentModifier
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer

@SideOnly(Side.CLIENT)
class PewterToolSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    private var pagesToRemove = mutableListOf<PageData>()

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentModifier) {
            val modifier = TinkerRegistry.getModifier((page.content as ContentModifier).modifierName)
            if (modifier != null) {

                if (modifier is PewterModifier) {
                    if (modifier.items.isNotEmpty()) {
                        println("${modifier.localizedName} has items: ${modifier.items.flatten().map { it.unlocalizedName }}")
                        listing.addEntry(modifier.localizedName, page)
                    } else {
                        pagesToRemove.add(page)
                    }
                } else {
                    println("${modifier.localizedName} not Pewter modifier, skipping (huh?)")
                }

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

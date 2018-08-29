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
import slimeknights.tconstruct.library.modifiers.IModifier

@SideOnly(Side.CLIENT)
class PewterToolSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentModifier) {
            val modifier = TinkerRegistry.getModifier((page.content as ContentModifier).modifierName)
            if (modifier != null) {

                if (modifier is PewterModifier) {
                    if (modifier.items.isNotEmpty()) {
                        println("${modifier.localizedName} has items: ${modifier.items.flatten().map { it.unlocalizedName }}")
                        listing.addEntry(modifier.localizedName, page)
                    } else {
                        //println("${modifier.localizedName} is Pewter but has no related items")
                    }
                } else {
                    println("${modifier.localizedName} not Pewter modifier, skipping (huh?)")
                }

            }
        }
    }


    private fun getModifierFromPage(page: PageData): IModifier? {
        return if (page.content is ContentModifier) {
            TinkerRegistry.getModifier((page.content as ContentModifier).modifierName)
        } else {
            null
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

        // This gets a map of all pages with pewter modifiers as keys with all associated items as values
        val pewterItemsFromPages = data.pages.mapNotNull {
            val modHere = getModifierFromPage(it)
            when (modHere) {
                is PewterModifier -> it to modHere.items.flatten()
                is PewterArmorModifier -> it to modHere.items.flatten()
                else -> null
            }
        }.toMap()

        // Grab all pages
        val pagesWithoutItems = pewterItemsFromPages.filter { it.value.isEmpty() }

        pagesWithoutItems.forEach { data.pages.remove(it.key) }

        data.pages.forEach { sectionPage -> processPage(book, listing, sectionPage) }

        if (listing.hasEntries()) {
            listingPage.load()

            data.pages.add(0, listingPage)
        }
    }



}

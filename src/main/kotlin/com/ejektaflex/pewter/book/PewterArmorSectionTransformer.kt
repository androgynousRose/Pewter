package com.ejektaflex.pewter.book

import c4.conarm.lib.ArmoryRegistry
import c4.conarm.lib.book.content.ContentArmorModifier
import c4.conarm.lib.modifiers.ArmorModifier
import com.ejektaflex.pewter.lib.modifiers.PewterArmorModifier
import com.ejektaflex.pewter.lib.modifiers.PewterModifier
import net.minecraft.item.ItemStack
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
class PewterArmorSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    private var pagesToRemove = mutableListOf<PageData>()

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentArmorModifier) {
            val modifier = ArmoryRegistry.getArmorModifier((page.content as ContentArmorModifier).modifierName)
            if (modifier != null && modifier is PewterArmorModifier) {

                val modItems = getArmorModItems(modifier)

                if (modItems != null) {
                    listing.addEntry(modifier.localizedName, page)
                } else {
                    pagesToRemove.add(page)
                }

            }
        }
    }

    // Apparently trying to get items from an ArmorModifier
    private fun getArmorModItems(mod: ArmorModifier): List<ItemStack>? {
        return try {
            mod.items.flatten()
        } catch (e: Exception) {
            null
        }
    }

    private fun getModifierFromPage(page: PageData): IModifier? {
        return if (page.content is ContentModifier) {
            ArmoryRegistry.getArmorModifier((page.content as ContentArmorModifier).modifierName)
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

    /*
    override fun transform(book: BookData, data: SectionData) {
        val listing = ContentListing()
        listing.title = book.translate(sectionName)

        val listingPage = PageData(true)
        listingPage.name = sectionName
        listingPage.source = data.source
        listingPage.parent = data
        listingPage.content = listing

        println("wax getting pewter pages")

        // This gets a map of all pages with pewter modifiers as keys with all associated items as values
        val pewterItemsFromPages = data.pages.mapNotNull {
            val modHere = getModifierFromPage(it)
            when (modHere) {
                is PewterModifier -> it to modHere.items.flatten()
                is PewterArmorModifier -> it to modHere.items.flatten()
                else -> null
            }
        }.toMap()

        println("wax filtering to only pages without items")

        println("wax ")

        for ((page, items) in pewterItemsFromPages) {
            println("wax \t page: ${page.title}, items: ${items.map { it.displayName }}")
        }

        // Grab all pages
        val pagesWithoutItems = pewterItemsFromPages.filter { it.value.isEmpty() }

        println("wax pages without items: ${pagesWithoutItems.map { it.key.title }}")

        pagesWithoutItems.forEach { data.pages.remove(it.key) }

        data.pages.forEach { sectionPage -> processPage(book, listing, sectionPage) }

        if (listing.hasEntries()) {
            listingPage.load()

            data.pages.add(0, listingPage)
        }
    }
    */

}

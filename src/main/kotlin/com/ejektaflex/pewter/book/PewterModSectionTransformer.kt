package com.ejektaflex.pewter.book

import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.book.content.ContentModifier
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer

@SideOnly(Side.CLIENT)
class PewterModSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentModifier) {
            val modifier = TinkerRegistry.getModifier((page.content as ContentModifier).modifierName)
            if (modifier != null) {
                listing.addEntry(modifier.localizedName, page)
            }
        }
    }
}

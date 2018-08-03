package com.ejektaflex.pewter.book

import com.ejektaflex.pewter.Pewter
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
class PewterModSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    override fun transform(book: BookData?, data: SectionData?) {
        Pewter.LOGGER.info("TRANSFORMING DATA... BEEP BOOP!")
        super.transform(book, data)
    }

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentModifier) {
            val modifier = TinkerRegistry.getModifier((page.content as ContentModifier).modifierName)
            if (modifier != null) {
                listing.addEntry(modifier.localizedName, page)
            }
        }
    }
}

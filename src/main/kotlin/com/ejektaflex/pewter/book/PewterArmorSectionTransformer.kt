package com.ejektaflex.pewter.book

import c4.conarm.lib.ArmoryRegistry
import c4.conarm.lib.book.content.ContentArmorModifier
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.book.content.ContentModifier
import slimeknights.tconstruct.library.book.sectiontransformer.ContentListingSectionTransformer

@SideOnly(Side.CLIENT)
class PewterArmorSectionTransformer(secName: String) : ContentListingSectionTransformer(secName) {

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        if (page.content is ContentArmorModifier) {
            val modifier = ArmoryRegistry.getArmorModifier((page.content as ContentArmorModifier).modifierName)
            if (modifier != null) {
                listing.addEntry(modifier.localizedName, page)
            }
        }
    }

}

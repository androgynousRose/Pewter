package com.ejektaflex.pewter.book

import c4.conarm.lib.book.content.ContentArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.PewterArmorModifier
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.mantle.client.book.data.content.PageContent
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.modifiers.IModifier

@SideOnly(Side.CLIENT)
class PewterArmorSectionTransformer(secName: String) : PewterContentListing<ContentArmorModifier>(secName) {

    override fun getModifierFromPage(content: PageContent): IModifier? {
        if (content is ContentArmorModifier) {
            return TinkerRegistry.getModifier(content.modifierName)
        }
        return null
    }

    override fun getModItems(mod: IModifier): List<ItemStack>? {
        return (mod as PewterArmorModifier).getItemsSafe()?.flatten()
    }

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        pewterProcessPage<PewterArmorModifier>(book, listing, page)
    }

}

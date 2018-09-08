package com.ejektaflex.pewter.book

import com.ejektaflex.pewter.lib.modifiers.PewterToolModifier
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.data.PageData
import slimeknights.mantle.client.book.data.content.PageContent
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.book.content.ContentListing
import slimeknights.tconstruct.library.book.content.ContentModifier
import slimeknights.tconstruct.library.modifiers.IModifier

@SideOnly(Side.CLIENT)
class PewterToolSectionTransformer(secName: String) : PewterContentListing<ContentModifier>(secName) {

    override fun getModifierFromPage(content: PageContent): IModifier? {
        if (content is ContentModifier) {
            return TinkerRegistry.getModifier((content).modifierName)
        }
        return null
    }

    override fun getModItems(mod: IModifier): List<ItemStack>? {
        return (mod as PewterToolModifier).getItemsSafe()?.flatten()
    }

    override fun processPage(book: BookData, listing: ContentListing, page: PageData) {
        pewterProcessPage<PewterToolModifier>(book, listing, page)
    }

}

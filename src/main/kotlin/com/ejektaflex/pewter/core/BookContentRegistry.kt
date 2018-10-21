package com.ejektaflex.pewter.core

import c4.conarm.lib.book.ArmoryBook
import com.ejektaflex.pewter.api.core.modifiers.IPewterArmorModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterModifier
import com.ejektaflex.pewter.api.core.modifiers.IPewterToolModifier
import com.ejektaflex.pewter.book.PewterArmorSectionTransformer
import com.ejektaflex.pewter.book.PewterContentListing
import com.ejektaflex.pewter.book.PewterToolSectionTransformer
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.content.PewterModifiers
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import slimeknights.mantle.client.book.data.BookData
import slimeknights.mantle.client.book.repository.FileRepository
import slimeknights.tconstruct.library.book.TinkerBook

object BookContentRegistry {

    val toolContent = mutableListOf<FileRepository>()

    val armorContent = mutableListOf<FileRepository>()

    fun setup() {
        toolContent.reversed().forEach {
            addTinkerBookSection(TinkerBook.INSTANCE, it)
        }

        if (Configs.main.isUsingConArm()) {
            armorContent.reversed().forEach {
                addArmoryBookSection(ArmoryBook.INSTANCE, it)
            }
        }

    }

    @SideOnly(Side.CLIENT)
    private fun addTinkerBookSection(book: BookData, repo: FileRepository) {
        if (getModifierItems<IPewterToolModifier>().isNotEmpty()) {
            setupBook(book, repo, PewterToolSectionTransformer(repo.sections[0].name))
        } else {
            PewterLogger.info("Pewter is not adding tool modifiers to Materials and You, no valid items exist")
        }
    }

    @SideOnly(Side.CLIENT)
    private fun addArmoryBookSection(book: BookData, repo: FileRepository) {
        if (getModifierItems<IPewterArmorModifier>().isNotEmpty()) {
            setupBook(book, repo, PewterArmorSectionTransformer(repo.sections[0].name))
        } else {
            PewterLogger.info("Pewter is not adding armor modifiers to Construct's Armory, no valid items exist")
        }
    }

    @SideOnly(Side.CLIENT)
    private inline fun <reified T : IPewterModifier> getModifierItems(): List<ItemStack> {
        return PewterModifiers.content.asSequence().filter {
            it is T
        }.mapNotNull {
            (it as T).getItemsSafe()?.flatten()
        }.toList().flatten()
    }

    @SideOnly(Side.CLIENT)
    private fun setupBook(book: BookData, repo: FileRepository, transformer: PewterContentListing<*>) {
        book.addRepository(repo)
        book.addTransformer(transformer)
        PewterLogger.verbose("Added modifiers to book \"$book\".")
    }



}
package com.ejektaflex.pewter


import c4.conarm.lib.ArmoryRegistry
import com.ejektaflex.pewter.command.Cycler
import com.ejektaflex.pewter.ext.sendMessage
import net.minecraft.command.CommandException
import net.minecraft.command.ICommand
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextFormatting
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.ModifierTrait
import slimeknights.tconstruct.library.tools.TinkerToolCore
import slimeknights.tconstruct.library.utils.TagUtil
import java.util.*

class DumpCommand : ICommand {

    private val colors = Cycler(listOf(TextFormatting.GREEN, TextFormatting.DARK_AQUA, TextFormatting.RED, TextFormatting.GOLD))

    override fun compareTo(other: ICommand): Int {
        return 0
    }

    override fun getName(): String {
        return Pewter.MODID
    }

    override fun getUsage(sender: ICommandSender): String {
        return "/${Pewter.MODID}"
    }

    override fun getAliases(): List<String> {
        val aliases = ArrayList<String>()
        aliases.add("pew")
        return aliases
    }

    @Throws(CommandException::class)
    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {

        if (args.isEmpty()) {
            sender.sendMessage("Valid options: '/pewter tooltraits', '/pewter armortraits'")
            return
        }

        val player = sender.commandSenderEntity as EntityPlayer

        val itemInHand = player.heldItemMainhand

        when (args[0]) {
            "dump" -> {
                if (itemInHand.item is TinkerToolCore) {
                    sender.sendMessage("Materials: ${TagUtil.getBaseMaterialsTagList(itemInHand)}")
                }
            }

            "armortraits" -> {
                if (Pewter.isUsingConArm()) {
                    val armorTraits = ArmoryRegistry.getAllArmorModifiers()
                    val listString = armorTraits.map { colors.cycle().toString() + "${it.localizedName} (${it.identifier})" }

                    sender.sendMessage(listString.toString())
                } else {
                    sender.sendMessage("Constructs Armory is not loaded!")
                }
            }

            "tooltraits" -> {
                val toolTraits = TinkerRegistry.getAllModifiers().toMutableList()

                if (Pewter.isUsingConArm()) {
                    toolTraits.removeIf { it in ArmoryRegistry.getAllArmorModifiers() }
                }

                val modifierTraits = toolTraits.filter { it is ModifierTrait }

                val listString = modifierTraits.map { colors.cycle().toString() + "${it.localizedName} (${it.identifier})" }

                sender.sendMessage(listString.toString())
            }

            else -> {
                sender.sendMessage("Invalid command. Valid options are: 'armortraits', 'tooltraits'.")
            }

        }

    }

    override fun checkPermission(server: MinecraftServer, sender: ICommandSender): Boolean {
        return sender is EntityPlayer
    }

    override fun getTabCompletions(server: MinecraftServer, sender: ICommandSender, args: Array<String>, pos: BlockPos?): List<String>? {
        return null
    }

    override fun isUsernameIndex(args: Array<String>, index: Int): Boolean {
        return false
    }

}


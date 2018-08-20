package com.ejektaflex.pewter


import net.minecraft.command.CommandException
import net.minecraft.command.ICommand
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import slimeknights.tconstruct.library.TinkerRegistry
import slimeknights.tconstruct.library.modifiers.Modifier
import slimeknights.tconstruct.library.modifiers.ModifierTrait
import slimeknights.tconstruct.library.tools.TinkerToolCore
import slimeknights.tconstruct.library.utils.TagUtil
import java.util.*

class DumpCommand : ICommand {

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
            return
        }

        val player = sender.commandSenderEntity as EntityPlayer

        val itemInHand = player.heldItemMainhand

        when (args[0]) {
            "dump" -> {
                if (itemInHand.item is TinkerToolCore) {
                    sender.sendMessage(TextComponentString("Materials: ${TagUtil.getBaseMaterialsTagList(itemInHand)}"))
                }
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


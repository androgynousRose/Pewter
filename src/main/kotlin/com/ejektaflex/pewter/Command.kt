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
import java.util.*


/**
 * Bulk of this class was taken from CraftTweaker where the Authors were listed as below
 * @author BloodWorkXGaming, Stan, Jared
 */
class Command : ICommand {

    override fun compareTo(other: ICommand): Int {
        return 0
    }

    override fun getName(): String {
        return Pewter.MODID
    }

    override fun getUsage(sender: ICommandSender): String {
        return "/${Pewter.MODID} traits"
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

        if (args[0] == "traits") {
            var traitString = ""
            for (modifier in TinkerRegistry.getAllModifiers()) {
                if (modifier is Modifier && modifier !is ModifierTrait) {
                    if (traitString.isNotEmpty()) traitString += ", "
                    traitString += "\"" + modifier.getIdentifier() + "\""
                }
            }
            sender.sendMessage(TextComponentString("The following Traits are registered: \u00A7e$traitString"))
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


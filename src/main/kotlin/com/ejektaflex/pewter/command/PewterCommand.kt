package com.ejektaflex.pewter.command


import c4.conarm.lib.ArmoryRegistry
import com.ejektaflex.pewter.Pewter
import com.ejektaflex.pewter.config.Configs
import com.ejektaflex.pewter.content.PewterMaterials
import com.ejektaflex.pewter.ext.sendMessage
import com.ejektaflex.pewter.lib.PewterInfo
import com.ejektaflex.pewter.logic.ListCycler
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

class PewterCommand : ICommand {

    private val colors = ListCycler(listOf(TextFormatting.GREEN, TextFormatting.DARK_AQUA, TextFormatting.RED, TextFormatting.GOLD))

    override fun compareTo(other: ICommand): Int {
        return 0
    }

    override fun getName(): String {
        return PewterInfo.MODID
    }

    override fun getUsage(sender: ICommandSender): String {
        return "/${PewterInfo.MODID}"
    }

    override fun getAliases(): List<String> {
        val aliases = ArrayList<String>()
        aliases.add("pew")
        return aliases
    }

    @Throws(CommandException::class)
    override fun execute(server: MinecraftServer, sender: ICommandSender, args: Array<String>) {

        if (args.isEmpty()) {
            sender.sendMessage("Valid options: '/pewter listmaterials|genfile|tooltraits|armortraits'")
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

            "genfile" -> {
                if (args.size == 2) {
                    val mat = PewterMaterials.content.find { it.data.name == args[1] }
                    if (mat != null) {
                        Configs.generateMaterialFile(Configs.configDir, mat.data)
                        sender.sendMessage("Generated file pewter/${mat.data.name}.json.")
                    } else {
                        sender.sendMessage(TextFormatting.DARK_AQUA.toString() + "Pewter never made a material named ${args[1]}" +
                                ", sorry! Use '/pewter listmaterials' to view all possible " +
                                "materials you can generate a file for.")
                    }
                } else {
                    sender.sendMessage(TextFormatting.RED.toString() + "Invalid number of arguments! Usage: '/pewter genfile [material identifier]'")
                }
            }

            "listmaterials" -> {
                if (PewterMaterials.content.isNotEmpty()) {
                    sender.sendMessage("All Pewter Materials Currently Loaded:")
                    val listString = PewterMaterials.content.map { colors.cycle().toString() + "${it.tinkMaterial.localizedName} (identifier: ${it.data.name})" }.sorted()
                    sender.sendMessage(listString.toString())
                } else {
                    sender.sendMessage("Pewter isn't adding any materials. Add some more mods?")
                }
            }

            "armortraits" -> {
                if (Configs.main.isUsingConArm()) {
                    val armorTraits = ArmoryRegistry.getAllArmorModifiers()
                    val listString = armorTraits.map { colors.cycle().toString() + "${it.localizedName} (identifier: ${it.identifier})" }.sorted()
                    sender.sendMessage(listString.toString())
                } else {
                    sender.sendMessage("Constructs Armory is not loaded!")
                }
            }

            "tooltraits" -> {
                val toolTraits = TinkerRegistry.getAllModifiers().toMutableList()

                if (Configs.main.isUsingConArm()) {
                    toolTraits.removeIf { it in ArmoryRegistry.getAllArmorModifiers() }
                }

                val modifierTraits = toolTraits.filter { it is ModifierTrait }

                val listString = modifierTraits.map { colors.cycle().toString() + "${it.localizedName} (${it.identifier})" }.sorted()

                sender.sendMessage(listString.toString())
            }

            else -> {
                sender.sendMessage("Invalid command. Valid options are: 'armortraits', 'tooltraits', 'listmaterials', 'genfile'.")
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


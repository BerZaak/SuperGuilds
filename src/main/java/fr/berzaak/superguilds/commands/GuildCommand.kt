package fr.berzaak.superguilds.commands

import fr.berzaak.superguilds.utils.commands.BCommand
import fr.berzaak.superguilds.utils.commands.Command
import fr.berzaak.superguilds.utils.commands.CommandArgs

class GuildCommand: BCommand {

    @Command(name = "guild", description = "Display all informations about guild")
    override fun onCommand(args: CommandArgs) {

        args.player.sendMessage("""
            
            §6/guild create <name> §f» §eCreate new guild
            §6/guild invite <player> §f» §eInvite a player to your guild
            §6/guild kick <player> §f» §eKick a player from your guild
            §6/guild join <guild> §f» §eJoin a guild who invited you
            §6/guild leave §f» §eLeave your actual guild
            §6/guild info <guild> §f» §eDisplay info about a guild
            §6/guild annonce <msg> §f» §eSend message to your guild
            §6/guild bank §f» §eOpens your guild's bank menu
            §6/guild upgrade §f» §eOpens your guild's upgrade menu
            
        """.trimIndent())

    }
}
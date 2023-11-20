package fr.berzaak.superguilds.commands

import fr.berzaak.superguilds.SuperGuilds
import fr.berzaak.superguilds.guild.Guild
import fr.berzaak.superguilds.utils.commands.BCommand
import fr.berzaak.superguilds.utils.commands.Command
import fr.berzaak.superguilds.utils.commands.CommandArgs

class GuildCreateCommand: BCommand {

    @Command(name = "guild.create", inGameOnly = true, description = "Create new guild")
    override fun onCommand(args: CommandArgs) {

        val player = args.player

        if (args.getArgs(0) == null) return player.sendMessage("§eUsage : /guild create <name>")

        val guildName = args.getArgs(0)

        if (SuperGuilds.instance.guildManager.getGuildFromName(guildName) != null) return player.sendMessage("§eA guild with that name already exists")

        val guild = Guild(guildName, player.uniqueId)
        SuperGuilds.instance.guildManager.createNewGuilds(guild)

    }


}
package fr.berzaak.superguilds.commands

import fr.berzaak.superguilds.SuperGuilds
import fr.berzaak.superguilds.cache.PlayerCache
import fr.berzaak.superguilds.guild.Guild
import fr.berzaak.superguilds.utils.commands.BCommand
import fr.berzaak.superguilds.utils.commands.Command
import fr.berzaak.superguilds.utils.commands.CommandArgs

class GuildCreateCommand: BCommand {

    @Command(name = "guild.create", inGameOnly = true, description = "Create new guild")
    override fun onCommand(args: CommandArgs) {

        val player = args.player
        val cache = PlayerCache.from(player.uniqueId)

        if (cache.guild != null) return player.sendMessage("§eYou're already in a guild")

        val guildName = args.getArgs(0)

        if (SuperGuilds.instance.guildManager.getGuildByName(guildName) != null) return player.sendMessage("§eA guild with that name already exists")

        val guild = Guild(guildName, player.uniqueId)
        SuperGuilds.instance.guildManager.addNewGuild(guild)

    }
}
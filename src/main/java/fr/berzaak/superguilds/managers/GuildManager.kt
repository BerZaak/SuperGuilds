package fr.berzaak.superguilds.managers

import fr.berzaak.superguilds.guild.Guild
import java.util.*

class GuildManager {

    val guilds: MutableMap<Guild, UUID> = mutableMapOf<Guild, UUID>()

    fun createNewGuilds(guild: Guild) {
        guilds[guild] = guild.owner
    }

    fun removeGuilds(guild: Guild) {
        guilds.remove(guild)
    }

    fun getGuildFromName(name: String): Guild? {
        return guilds.keys.firstOrNull { it.name == name }
    }

}
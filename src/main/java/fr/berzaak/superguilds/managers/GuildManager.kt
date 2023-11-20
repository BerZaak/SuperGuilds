package fr.berzaak.superguilds.managers

import fr.berzaak.superguilds.cache.PlayerCache
import fr.berzaak.superguilds.guild.Guild

class GuildManager {

    private val guilds = mutableSetOf<Guild>()

    fun addNewGuild(guild: Guild) {
        guilds.add(guild)
        PlayerCache.from(guild.owner).guild = guild
    }

    fun removeGuild(guild: Guild) = guilds.remove(guild)

    fun getGuildByName(name: String): Guild? = guilds.firstOrNull { it.name == name }

}
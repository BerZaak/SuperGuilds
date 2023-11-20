package fr.berzaak.superguilds.managers

import fr.berzaak.superguilds.guild.Guild

class GuildManager {

    val guilds = mutableListOf<Guild>()

    fun createNewGuilds(guild: Guild) {
        guilds.add(guild)
    }

    fun removeGuilds(guild: Guild) {
        guilds.remove(guild)
    }

    fun getGuildFromName(name: String): Guild? {
        return guilds.firstOrNull { it.name == name }
    }

}
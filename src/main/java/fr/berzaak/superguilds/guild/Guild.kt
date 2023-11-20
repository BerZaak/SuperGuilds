package fr.berzaak.superguilds.guild

import java.util.*

class Guild(val name: String, val owner: UUID) {

    val tier = GuildTier(1, 5, 10)
    val members = mutableSetOf<UUID>()

}
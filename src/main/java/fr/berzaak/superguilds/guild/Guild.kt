package fr.berzaak.superguilds.guild

import fr.berzaak.superguilds.cache.PlayerCache
import java.util.UUID

class Guild(val name: String, val owner: UUID) {

    val members = mutableMapOf<UUID, GuildRank>()

    fun addMember(uuid: UUID, rank: GuildRank? = GuildRank.NEWBIE) {
        members[uuid] = rank!!
        PlayerCache.from(uuid).guild = this
    }

    fun removeMember(uuid: UUID) {
        members.remove(uuid)
        PlayerCache.from(uuid).guild = null
    }

}
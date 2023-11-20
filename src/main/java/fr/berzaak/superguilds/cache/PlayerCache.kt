package fr.berzaak.superguilds.cache

import com.github.benmanes.caffeine.cache.Caffeine
import fr.berzaak.superguilds.guild.Guild
import java.util.UUID

class PlayerCache private constructor(uuid: UUID) {

    var guild: Guild? = null

    companion object {

        private val cache = Caffeine.newBuilder().build<UUID, PlayerCache>()

        fun init(uuid: UUID) = cache.put(uuid, PlayerCache(uuid))

        fun from(uuid: UUID): PlayerCache = cache.getIfPresent(uuid)!!

        fun delete(uuid: UUID) = cache.invalidate(uuid)

    }

}
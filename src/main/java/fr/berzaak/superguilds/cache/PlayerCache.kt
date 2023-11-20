package fr.berzaak.superguilds.cache

import com.github.benmanes.caffeine.cache.Caffeine
import fr.berzaak.superguilds.guild.Guild
import org.bukkit.entity.Player
import java.util.*

class PlayerCache private constructor(val uuid: UUID, val name: String){

    var guild: Guild? = null

    companion object {

        private val cache = Caffeine.newBuilder().build<UUID, PlayerCache>()

        fun from(player: Player): PlayerCache? {
            return cache.get(player.uniqueId) { PlayerCache(player.uniqueId, player.name) }
        }

        fun getAllCaches(): Collection<PlayerCache> {
            return cache.asMap().values
        }

        fun delete(player: Player) {
            cache.invalidate(player.uniqueId)
        }

    }

}
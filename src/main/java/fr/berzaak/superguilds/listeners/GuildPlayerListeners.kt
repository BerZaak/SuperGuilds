package fr.berzaak.superguilds.listeners

import fr.berzaak.superguilds.cache.PlayerCache
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class GuildPlayerListeners: Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        PlayerCache.init(event.player.uniqueId)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        PlayerCache.delete(event.player.uniqueId)
    }

}
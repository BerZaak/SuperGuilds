package fr.berzaak.superguilds.listeners;

import fr.berzaak.superguilds.SuperGuilds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.CompletableFuture;

public final class PlayerListener implements Listener {

    private final SuperGuilds instance = SuperGuilds.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        CompletableFuture.runAsync(() -> instance.getPlayerManager().loadGuildPlayer(event.getPlayer().getUniqueId()), instance.getExecutorService());

    }

    public void onQuit(PlayerQuitEvent event) {

        CompletableFuture.runAsync(() -> instance.getPlayerManager().unloadGuildPlayer(event.getPlayer().getUniqueId()), instance.getExecutorService());

    }
}

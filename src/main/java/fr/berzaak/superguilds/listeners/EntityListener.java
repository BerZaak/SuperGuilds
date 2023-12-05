package fr.berzaak.superguilds.listeners;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.tier.Tier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class EntityListener implements Listener {

    private final PlayerManager playerManager = SuperGuilds.getInstance().getPlayerManager();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntity().getKiller() == null) return;

        Player player = event.getEntity().getKiller();
        GuildPlayer guildPlayer = playerManager.getGuildPlayer(player.getUniqueId());

        guildPlayer.getGuild().ifPresent(guild -> {

            Tier xpMultiplier = guild.getGuildTier().getXpMultiplier();

            double finalXp = event.getDroppedExp() * xpMultiplier.getMultiplier(xpMultiplier.getLevel());
            event.setDroppedExp((int) finalXp);
            player.sendMessage("§aDebug -- XpMultiplier used : §2x" + xpMultiplier.getMultiplier(xpMultiplier.getLevel()));

        });
    }
}

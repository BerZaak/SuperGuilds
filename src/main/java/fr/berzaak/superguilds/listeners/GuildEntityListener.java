package fr.berzaak.superguilds.listeners;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.tier.Tier;
import fr.berzaak.superguilds.utils.GPlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public final class GuildEntityListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntity().getKiller() == null) return;

        Player player = event.getEntity().getKiller();
        GuildPlayer guildPlayer = SuperGuilds.getInstance().getGuildManager().getGuildPlayer(player.getUniqueId());

        if (GPlayerUtils.hasGuild(guildPlayer)) {

            Tier xpMultiplier = guildPlayer.getGuild().getGuildTier().getXpMultiplier();

            double finalXp = event.getDroppedExp() * xpMultiplier.getMultiplier(xpMultiplier.getLevel());
            event.setDroppedExp((int) finalXp);
            player.sendMessage("§aDebug -- XpMultiplier used : §2x" + xpMultiplier.getMultiplier(xpMultiplier.getLevel()));

        }

    }

}

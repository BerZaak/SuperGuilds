package fr.berzaak.superguilds.listeners;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.guild.Guild;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.quests.QuestType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockListener implements Listener {

    private final PlayerManager playerManager = SuperGuilds.getInstance().getPlayerManager();

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {

        final Player player = event.getPlayer();
        final GuildPlayer guildPlayer = playerManager.getGuildPlayer(player.getUniqueId());

        if (guildPlayer.getGuild().isPresent()) {

            Guild guild = guildPlayer.getGuild().get();

            guild.getActiveQuest().ifPresent(quest -> {

                if (quest.getQuestType() == QuestType.PLACE_BLOCK) {

                    guild.advanceQuest();

                }
            });
        }
    }
}

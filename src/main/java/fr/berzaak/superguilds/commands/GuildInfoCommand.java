package fr.berzaak.superguilds.commands;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.gui.GuildUpgradeInventory;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.utils.commands.BCommand;
import fr.berzaak.superguilds.utils.commands.Command;
import fr.berzaak.superguilds.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

public final class GuildInfoCommand implements BCommand {

    private final PlayerManager playerManager = SuperGuilds.getInstance().getPlayerManager();

    @Override
    @Command(name = "guild.info", aliases = "guilds.info", description = "Display informations about a guild")
    public void onCommand(CommandArgs args) {

        final Player player = args.getPlayer();
        final GuildPlayer guildPlayer = playerManager.getGuildPlayer(player.getUniqueId());




    }
}

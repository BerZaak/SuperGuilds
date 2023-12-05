package fr.berzaak.superguilds.commands;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.gui.GuildUpgradeInventory;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.manager.GuildManager;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.utils.commands.BCommand;
import fr.berzaak.superguilds.utils.commands.Command;
import fr.berzaak.superguilds.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

public final class GuildUpgradeCommand implements BCommand {

    private final PlayerManager playerManager = SuperGuilds.getInstance().getPlayerManager();

    @Override
    @Command(name = "guild.upgrade", inGameOnly = true)
    public void onCommand(CommandArgs args) {

        Player player = args.getPlayer();
        GuildPlayer guildPlayer = playerManager.getGuildPlayer(player.getUniqueId());

        if (guildPlayer.getGuild().isPresent()) {
            GuildUpgradeInventory.INVENTORY.open(player);
        } else {
            player.sendMessage("§eYou're not in a guild");
        }
    }
}

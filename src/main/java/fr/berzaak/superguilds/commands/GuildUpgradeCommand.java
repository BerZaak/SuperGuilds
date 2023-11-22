package fr.berzaak.superguilds.commands;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.gui.GuildUpgradeInventory;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.utils.GPlayerUtils;
import fr.berzaak.superguilds.utils.commands.BCommand;
import fr.berzaak.superguilds.utils.commands.Command;
import fr.berzaak.superguilds.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

public final class GuildUpgradeCommand implements BCommand {

    @Override
    @Command(name = "guild.upgrade", inGameOnly = true)
    public void onCommand(CommandArgs args) {

        Player player = args.getPlayer();
        GuildPlayer guildPlayer = SuperGuilds.getInstance().getGuildManager().getGuildPlayer(player.getUniqueId());

        if (!GPlayerUtils.hasGuild(guildPlayer)) {
            player.sendMessage("§eYou don't have guild");
            return;
        }

        GuildUpgradeInventory.INVENTORY.open(player);

    }
}

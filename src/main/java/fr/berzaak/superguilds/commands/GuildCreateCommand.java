package fr.berzaak.superguilds.commands;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.utils.GPlayerUtils;
import fr.berzaak.superguilds.utils.commands.BCommand;
import fr.berzaak.superguilds.utils.commands.Command;
import fr.berzaak.superguilds.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

public final class GuildCreateCommand implements BCommand {


    @Override
    @Command(name = "guild.create", inGameOnly = true, description = "Create new guild")
    public void onCommand(CommandArgs args) {

        if (args.length() != 1) return;

        Player player = args.getPlayer();

        if (GPlayerUtils.hasGuild(SuperGuilds.getInstance().getGuildManager().getGuildPlayer(player.getUniqueId()))) {
            player.sendMessage("§eYou're already in a guild");
            return;
        }



    }
}

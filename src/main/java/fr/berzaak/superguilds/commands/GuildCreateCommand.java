package fr.berzaak.superguilds.commands;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.guild.Guild;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.manager.GuildManager;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.utils.commands.BCommand;
import fr.berzaak.superguilds.utils.commands.Command;
import fr.berzaak.superguilds.utils.commands.CommandArgs;
import org.bukkit.entity.Player;

public final class GuildCreateCommand implements BCommand {

    private final PlayerManager playerManager = SuperGuilds.getInstance().getPlayerManager();
    private final GuildManager guildManager = SuperGuilds.getInstance().getGuildManager();

    @Override
    @Command(name = "guild.create", inGameOnly = true, description = "Create new guild")
    public void onCommand(CommandArgs args) {

        if (args.length() != 1) return;

        Player player = args.getPlayer();
        GuildPlayer guildPlayer = playerManager.getGuildPlayer(player.getUniqueId());

        if (guildPlayer.getGuild().isPresent()) {

            player.sendMessage("§cYou're already in a guild !");

        } else {

            Guild guild = new Guild(args.getArgs(0), guildPlayer);

            guildManager.createNewGuild(guild);

            player.sendMessage("§eYou just created the new guild : §6" + args.getArgs(0));

        }


    }
}

package fr.berzaak.superguilds.utils;

import fr.berzaak.superguilds.guild.GuildPlayer;

public final class GPlayerUtils {

    public static boolean hasGuild(GuildPlayer player) {
        return player.getGuild() != null;
    }

}

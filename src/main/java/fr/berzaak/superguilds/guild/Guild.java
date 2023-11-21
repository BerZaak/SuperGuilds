package fr.berzaak.superguilds.guild;

import com.google.common.collect.Sets;

import java.util.Set;

public final class Guild {

    private final Set<GuildPlayer> players = Sets.newHashSet();
    private final GuildTier guildTier;

    public Guild(String name, GuildPlayer owner) {
        guildTier = new GuildTier(1);
    }

    public Set<GuildPlayer> getPlayers() {
        return players;
    }

    public GuildTier getGuildTier() {
        return guildTier;
    }
}

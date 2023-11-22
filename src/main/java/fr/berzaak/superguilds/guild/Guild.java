package fr.berzaak.superguilds.guild;

import com.google.common.collect.Sets;

import java.util.Set;

public final class Guild {

    private final Set<GuildPlayer> players = Sets.newHashSet();
    private final GuildTier guildTier;
    private final GuildPlayer owner;
    private final String name;

    public Guild(String name, GuildPlayer owner) {
        guildTier = new GuildTier(1);
        this.owner = owner;
        this.name = name;
        this.players.add(owner);
    }

    public Set<GuildPlayer> getPlayers() {
        return players;
    }

    public GuildTier getGuildTier() {
        return guildTier;
    }

    public GuildPlayer getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}

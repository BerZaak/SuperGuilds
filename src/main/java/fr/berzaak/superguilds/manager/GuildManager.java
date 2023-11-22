package fr.berzaak.superguilds.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import fr.berzaak.superguilds.guild.Guild;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.utils.GPlayerUtils;

import java.util.List;
import java.util.UUID;

public final class GuildManager {

    private final List<Guild> guilds = Lists.newArrayList();
    private final Cache<UUID, GuildPlayer> players = CacheBuilder.newBuilder().build();

    public List<Guild> getGuilds() {
        return guilds;
    }

    public GuildPlayer getGuildPlayer(UUID uuid) {
        return players.getIfPresent(uuid);
    }

    public boolean isSameTeam(UUID first, UUID second) {

        if (!GPlayerUtils.hasGuild(getGuildPlayer(first)) || !GPlayerUtils.hasGuild(getGuildPlayer(second))) return false;

        return getGuildPlayer(first).getGuild().equals(getGuildPlayer(second).getGuild());

    }

    public void createNewGuild(Guild guild) {
        guilds.add(guild);
        guild.getOwner().setGuild(guild);
    }

    public void loadGuildPlayer(UUID uuid) {
        players.put(uuid, new GuildPlayer(uuid));
    }

    public void unloadGuildPlayer(UUID uuid) {
        players.invalidate(uuid);
    }

}

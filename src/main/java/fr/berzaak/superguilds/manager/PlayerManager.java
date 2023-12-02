package fr.berzaak.superguilds.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import fr.berzaak.superguilds.guild.GuildPlayer;

import java.util.UUID;

public final class PlayerManager {

    private final Cache<UUID, GuildPlayer> players = CacheBuilder.newBuilder().build();

    public GuildPlayer getGuildPlayer(UUID uuid) {
        return players.getIfPresent(uuid);
    }

    public boolean isSameTeam(UUID first, UUID second) {

        if (getGuildPlayer(first).getGuild().isPresent() && getGuildPlayer(second).getGuild().isPresent()) {

            return getGuildPlayer(first).getGuild().get().equals(getGuildPlayer(second).getGuild().get());

        }

        return false;

    }

    public void loadGuildPlayer(UUID uuid) {
        players.put(uuid, new GuildPlayer(uuid));
    }

    public void unloadGuildPlayer(UUID uuid) {
        players.invalidate(uuid);
    }

}

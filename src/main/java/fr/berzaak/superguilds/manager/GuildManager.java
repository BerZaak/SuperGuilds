package fr.berzaak.superguilds.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fr.berzaak.superguilds.guild.Guild;
import fr.berzaak.superguilds.guild.GuildPlayer;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class GuildManager {

    private final List<Guild> guilds = Lists.newArrayList();
    private final Map<UUID, GuildPlayer> players = Maps.newHashMap();

    public GuildManager() {

    }


    public List<Guild> getGuilds() {
        return guilds;
    }

    public GuildPlayer getGuildPlayer(UUID uuid) {
        return players.get(uuid);
    }

    public void loadGuildPlayer(UUID uuid) {
        players.put(uuid, new GuildPlayer(uuid));
    }

    public void unloadGuildPlayer(UUID uuid) {
        players.remove(uuid);
    }

}

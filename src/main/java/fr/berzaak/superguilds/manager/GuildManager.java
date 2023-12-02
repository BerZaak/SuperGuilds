package fr.berzaak.superguilds.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fr.berzaak.superguilds.guild.Guild;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class GuildManager {

    private final Map<String, Guild> guilds = Maps.newHashMap();

    public List<Guild> getGuilds() {
        return Lists.newArrayList(guilds.values());
    }

    public void createNewGuild(Guild guild) {
        guilds.put(guild.getName(), guild);
        guild.getOwner().setGuild(guild);
    }

    public Optional<Guild> getGuildByName(String name) {
        return Optional.ofNullable(guilds.get(name));
    }

}

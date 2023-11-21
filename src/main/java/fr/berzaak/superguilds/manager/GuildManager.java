package fr.berzaak.superguilds.manager;

import com.google.common.collect.Lists;
import fr.berzaak.superguilds.guild.Guild;

import java.util.List;

public final class GuildManager {

    private final List<Guild> guilds = Lists.newArrayList();

    public GuildManager() {

    }

    

    public List<Guild> getGuilds() {
        return guilds;
    }
}

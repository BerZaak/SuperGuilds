package fr.berzaak.superguilds.guild;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public final class GuildPlayer {

    private final UUID uuid;
    private Guild guild;

    public GuildPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Optional<Guild> getGuild() {
        return Optional.ofNullable(guild);
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Player toPlayer() {
        return Bukkit.getPlayer(uuid);
    }

}

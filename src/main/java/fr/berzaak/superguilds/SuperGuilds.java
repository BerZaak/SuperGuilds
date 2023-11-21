package fr.berzaak.superguilds;

import fr.berzaak.superguilds.listeners.GuildPlayerListener;
import fr.berzaak.superguilds.manager.GuildManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SuperGuilds extends JavaPlugin {

    private static SuperGuilds instance;
    private final GuildManager guildManager = new GuildManager();


    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new GuildPlayerListener(), this);

        Bukkit.getLogger().log(Level.FINE, "SuperGuilds - Enabled !");
        instance = this;
    }


    @Override
    public void onDisable() {

    }

    public static SuperGuilds getInstance() {
        return instance;
    }

    public GuildManager getGuildManager() {
        return guildManager;
    }
}

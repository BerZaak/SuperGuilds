package fr.berzaak.superguilds;

import fr.berzaak.superguilds.commands.GuildCreateCommand;
import fr.berzaak.superguilds.commands.GuildUpgradeCommand;
import fr.berzaak.superguilds.listeners.GuildEntityListener;
import fr.berzaak.superguilds.listeners.GuildPlayerListener;
import fr.berzaak.superguilds.manager.GuildManager;
import fr.berzaak.superguilds.utils.commands.CommandFramework;
import fr.minuskube.inv.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SuperGuilds extends JavaPlugin {

    private static SuperGuilds instance;
    private final GuildManager guildManager = new GuildManager();
    private InventoryManager inventoryManager;


    @Override
    public void onEnable() {
        instance = this;
        inventoryManager = new InventoryManager(this);
        inventoryManager.init();


        Bukkit.getPluginManager().registerEvents(new GuildPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new GuildEntityListener(), this);

        Bukkit.getLogger().log(Level.FINE, "SuperGuilds - Enabled !");

        CommandFramework commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new GuildCreateCommand());
        commandFramework.registerCommands(new GuildUpgradeCommand());

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

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}

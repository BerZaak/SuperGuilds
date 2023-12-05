package fr.berzaak.superguilds;

import fr.berzaak.superguilds.commands.GuildCreateCommand;
import fr.berzaak.superguilds.commands.GuildQuestCommand;
import fr.berzaak.superguilds.commands.GuildUpgradeCommand;
import fr.berzaak.superguilds.listeners.BlockListener;
import fr.berzaak.superguilds.listeners.EntityListener;
import fr.berzaak.superguilds.listeners.PlayerListener;
import fr.berzaak.superguilds.manager.GuildManager;
import fr.berzaak.superguilds.manager.PlayerManager;
import fr.berzaak.superguilds.manager.QuestManager;
import fr.berzaak.superguilds.utils.commands.CommandFramework;
import fr.minuskube.inv.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public final class SuperGuilds extends JavaPlugin {

    private static SuperGuilds instance;
    private final GuildManager guildManager = new GuildManager();
    private final PlayerManager playerManager = new PlayerManager();
    private final QuestManager questManager = new QuestManager();
    private InventoryManager inventoryManager;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);


    @Override
    public void onEnable() {
        instance = this;
        inventoryManager = new InventoryManager(this);
        inventoryManager.init();


        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListener(), this);

        Bukkit.getLogger().log(Level.FINE, "SuperGuilds - Enabled !");

        CommandFramework commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new GuildCreateCommand());
        commandFramework.registerCommands(new GuildUpgradeCommand());
        commandFramework.registerCommands(new GuildQuestCommand());

    }


    @Override
    public void onDisable() {
        executorService.shutdown();
    }

    public static SuperGuilds getInstance() {
        return instance;
    }

    public GuildManager getGuildManager() {
        return guildManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

}

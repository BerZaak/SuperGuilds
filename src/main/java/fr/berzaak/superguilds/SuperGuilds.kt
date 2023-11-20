package fr.berzaak.superguilds

import fr.berzaak.superguilds.commands.GuildCommand
import fr.berzaak.superguilds.commands.GuildCreateCommand
import fr.berzaak.superguilds.listeners.GuildPlayerListeners
import fr.berzaak.superguilds.managers.GuildManager
import fr.berzaak.superguilds.utils.commands.CommandFramework
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SuperGuilds : JavaPlugin() {

    val guildManager = GuildManager()

    override fun onEnable() {
        instance = this

        /* Register Listeners */
        Bukkit.getPluginManager().registerEvents(GuildPlayerListeners(), this)

        /* Register Commands */
        val commandFramework = CommandFramework(this)
        commandFramework.registerCommands(GuildCommand())
        commandFramework.registerCommands(GuildCreateCommand())

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        lateinit var instance: SuperGuilds
            private set
    }

}

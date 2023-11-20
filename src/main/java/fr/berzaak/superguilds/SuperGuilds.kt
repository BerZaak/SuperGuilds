package fr.berzaak.superguilds

import fr.berzaak.superguilds.commands.GuildCreateCommand
import fr.berzaak.superguilds.managers.GuildManager
import fr.berzaak.superguilds.utils.commands.CommandFramework
import org.bukkit.plugin.java.JavaPlugin

class SuperGuilds : JavaPlugin() {

    val guildManager = GuildManager()

    override fun onEnable() {
        instance = this

        /* Register Commands */
        val commandFramework = CommandFramework(this)
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

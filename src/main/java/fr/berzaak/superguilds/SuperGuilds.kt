package fr.berzaak.superguilds

import fr.berzaak.superguilds.commands.GuildCommand
import fr.berzaak.superguilds.utils.commands.CommandFramework
import org.bukkit.plugin.java.JavaPlugin

class SuperGuilds : JavaPlugin() {



    override fun onEnable() {
        instance = this

        /* Register Commands */
        val commandFramework = CommandFramework(this)
        commandFramework.registerCommands(GuildCommand())

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        lateinit var instance: SuperGuilds
            private set
    }

}

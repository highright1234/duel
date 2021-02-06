package org.projecttl.plugin.duel

import com.github.highright1234.duel.ArgumentForCommands
import com.github.highright1234.duel.Commands
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.duel.commands.GUIItemAdder
import org.projecttl.plugin.duel.commands.arguments.ArgumentForItemAdder
import org.projecttl.plugin.duel.listeners.DuelGUIListener
import java.io.File

class DuelPlugin: JavaPlugin() {

    private var configFile: File? = null
    private var configuration: FileConfiguration? = null
    private val manager = server.pluginManager

    override fun onEnable() {
        load()
        logger.info("Plugin has enabled.")
        getCommand("duel")?.setExecutor(Commands())
        getCommand("duel")?.tabCompleter = ArgumentForCommands()

        getCommand("duelitem")?.setExecutor(GUIItemAdder())
        getCommand("duelitem")?.tabCompleter = ArgumentForItemAdder()

        manager.registerEvents(DuelGUIListener(), this)
        /* 하이라이트를 위한 메뉴얼
         * Command: getCommand("example")?.setExecutor(ExampleClass())
         * Listener: manager.registerEvents(ExampleClass(), this)
         * TabListener: getCommand("example")?.tabCompleter = ArgumentForItemAdder()
         */
    }

    override fun onDisable() {
        save()
        logger.info("Plugin has disabled.")
    }

    private fun load() {
        configFile = File(dataFolder, "config.yml").also { config ->
            if (!config.exists()) {
                configuration?.save(config)
            }

            configuration?.load(config)
        }
        configuration = YamlConfiguration.loadConfiguration(configFile!!)
    }

    private fun save() {
        configuration?.save(configFile!!)
    }

    fun duelConfig(): FileConfiguration {
        return configuration!! // This is yaml config
    }
}

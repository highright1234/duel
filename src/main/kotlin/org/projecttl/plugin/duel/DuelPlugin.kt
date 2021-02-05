package org.projecttl.plugin.duel

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class DuelPlugin: JavaPlugin() {

    private var configFile: File? = null
    private var configuration: FileConfiguration? = null

    override fun onEnable() {
        load()
        logger.info("Plugin has enabled.")
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
        return configuration!!
    }
}
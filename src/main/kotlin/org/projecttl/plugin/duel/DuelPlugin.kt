package org.projecttl.plugin.duel

import com.github.highright1234.duel.ArgumentForCommands
import com.github.highright1234.duel.Commands
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.duel.commands.GUIItemAdder
import org.projecttl.plugin.duel.commands.arguments.ArgumentForItemAdder
import org.projecttl.plugin.duel.listeners.DuelGUIListener
import org.projecttl.plugin.duel.listeners.PlayerDeathListener
import xyz.namutree0345.langlib.LangLib
import xyz.namutree0345.langlib.structures.LanguageStructure
import java.io.File

var selectedLanguage: LanguageStructure? = null

class DuelPlugin: JavaPlugin() {

    private var configFile: File? = null
    private var configuration: FileConfiguration? = null
    private val manager = server.pluginManager

    override fun onEnable() {

        logger.info("Language Initializing...")

        val lib = LangLib.getInstance()
        val korean = lib.getLanguage("ko_KR").also {
            it.addNode("plugin_enabled", "플러그인이 활성화되었습니다.")
            it.addNode("plugin_disabled", "플러그인이 비활성화되었습니다.")
            it.addNode("duel_invite_command", "/duel invite <플레이어이름>")
            it.addNode("duel_accept_command", "/duel accept <플레이어이름>")
            it.addNode("duel_deny_command", "/duel deny <플레이어이름>")
            it.addNode("duel_help_duel_invite", "1. 듀얼신청: {0}")
            it.addNode("duel_help_duel_accept", "2. 듀얼수락: {0}")
            it.addNode("duel_help_duel_deny", "3. 듀얼거절: {0}")
            it.addNode("game_already_working", "게임이 이미 작동중입니다.")
            it.addNode("some_already_playing", "이미 누군가 플레이중입니다")
            it.addNode("player_offline", "플레이어가 오프라인입니다!")
            it.addNode("could_run_by_player", "이 커맨드는 플레이어만 실행할 수 있습니다!")
        }
        selectedLanguage = korean

        load()

        logger.info(selectedLanguage!!.getNode("plugin_enabled"))
        getCommand("duel")?.setExecutor(Commands(this))
        getCommand("duel")?.tabCompleter = ArgumentForCommands()

        getCommand("duelitem")?.setExecutor(GUIItemAdder())
        getCommand("duelitem")?.tabCompleter = ArgumentForItemAdder()

        manager.registerEvents(DuelGUIListener(), this)
        manager.registerEvents(PlayerDeathListener(this), this)

        /* 하이라이트를 위한 메뉴얼
         * Command: getCommand("example")?.setExecutor(ExampleClass())
         * Listener: manager.registerEvents(ExampleClass(), this)
         * TabListener: getCommand("example")?.tabCompleter = ArgumentForItemAdder()
         */
    }

    override fun onDisable() {
        save()
        logger.info(selectedLanguage!!.getNode("plugin_disabled"))
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

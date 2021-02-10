package org.projecttl.plugin.duel.utils

import com.github.highright1234.duel.Before
import org.bukkit.entity.Player
import org.projecttl.plugin.duel.DuelPlugin

class EndGame(val plugin: DuelPlugin, private var getKiller: Player, private var getDeadMan: Player) {

    private val getKillStatus: Int = plugin.duelConfig().getInt("duel.${getKiller.name}.status.kill")
    private val getDeathStatus: Int = plugin.duelConfig().getInt("duel.${getDeadMan.name}.status.death")

    init {
        Before.playing = false
        plugin.duelConfig().set("duel.${getKiller.name}.status.kill", getKillStatus + 1)
        plugin.duelConfig().set("duel.${getDeadMan.name}.status.death", getDeathStatus + 1) // Fix error [ kill -> death ]

        plugin.server.scheduler.cancelTasks(plugin)
    }
}
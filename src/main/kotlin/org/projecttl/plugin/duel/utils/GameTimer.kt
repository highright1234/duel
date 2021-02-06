package org.projecttl.plugin.duel.utils

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Score
import org.bukkit.scoreboard.Scoreboard
import org.projecttl.plugin.duel.DuelPlugin

@Suppress("DEPRECATION")
class GameTimer(private val plugin: DuelPlugin) {

    private var count: Int? = null

    private var objective: Objective
    private var timerBoard: Scoreboard? = null
    private var timerObject: Objective? = null

    init {
        count = 300 // Game Time is 5 Minutes
        val scoreboard: Scoreboard = Bukkit.getServer().scoreboardManager.newScoreboard.let {
            objective = it.registerNewObjective("Left_Time", "dummy", "${ChatColor.GREEN}Left Time")

            it
        }

        objective.displaySlot = DisplaySlot.SIDEBAR

        timerBoard = scoreboard
        timerObject = objective
    }

    fun runTimer() {
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(plugin, { timerFunction() }, 0L, 20L)
    }

    private fun timerFunction() {
        count = count!! - 1
        val score: Score = objective.getScore(Bukkit.getOfflinePlayer("${ChatColor.GREEN}Time:"))
        score.score = count!!

        if (count == 0) {
            plugin.server.scheduler.cancelTasks(plugin)
        }
    }
}
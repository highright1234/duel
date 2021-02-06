package org.projecttl.plugin.duel.listeners

import com.github.highright1234.duel.Before
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.projecttl.plugin.duel.DuelPlugin
import org.projecttl.plugin.duel.utils.EndGame

class PlayerDeathListener(private val plugin: DuelPlugin): Listener {

    private var redPlayer: Player = Before.redPlayer
    private var bluePlayer: Player = Before.bluePlayer

    @EventHandler
    fun deathListener(event: PlayerDeathEvent) {
        if (Before.playing) {

            if (redPlayer.isDead) {
                EndGame(plugin, bluePlayer, redPlayer)
            } else if (bluePlayer.isDead) {
                EndGame(plugin, redPlayer, bluePlayer)
            }
        }
    }
}
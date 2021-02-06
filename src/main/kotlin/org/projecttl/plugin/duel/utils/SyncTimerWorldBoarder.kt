package org.projecttl.plugin.duel.utils

import org.projecttl.plugin.duel.DuelPlugin

class SyncTimerWorldBoarder(private val plugin: DuelPlugin) {

    fun setDefault() {
        GameTimer(plugin).runTimer()
    }

    fun queryWorldBoarder(getCount: Int) {
        // TODO Query WorldBoarder
    }
}
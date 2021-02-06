package org.projecttl.plugin.duel.utils

import com.github.highright1234.duel.Before
import org.bukkit.entity.Player

class EndGame(private var getKiller: Player) {

    init {
        Before.playing = false
    }
}
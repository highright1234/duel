package org.projecttl.plugin.duel.utils

import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.entity.Player
import org.projecttl.plugin.duel.DuelPlugin

class CreateSessionWorld(val plugin: DuelPlugin, val player: Player) {
    // Session Test
    /*
     * This class is only session test code!
     * There is not workspace
     */

    private val sessionCount = plugin.duelConfig().getInt("duel.session.count")
    var playGame = false
    val worldName = "session-$sessionCount"

    fun getSession() {
        if (!playGame) {
            val sessionCreate: WorldCreator = WorldCreator(worldName).let { worldCreator ->
                worldCreator.environment(World.Environment.NORMAL)
                worldCreator.type(WorldType.FLAT)
                worldCreator.generatorSettings("minecraft:bedrock,2*minecraft:dirt,minecraft:grass_block;minecraft:plains")
                worldCreator.generateStructures(false)
                worldCreator.seed(4543815200869249576)

                worldCreator
            }

            Bukkit.getWorlds().add(sessionCreate.createWorld())
        } else {
            player.sendMessage("<duel> Game is already started.")
        }
    }
}
package com.github.highright1234.duel;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.projecttl.plugin.duel.DuelPlugin;

public class CreateSession {

    private final DuelPlugin plugin;
    public CreateSession(DuelPlugin plugin) {
        this.plugin = plugin;
    }

    /* TODO | Work start Highright. */

    /* Requirement
     * You're not add single session, must add multiple session.
     * You're must not ignore TODO list.
     */

    String worldName = null; // You will define it.

    public void createSession() {
        WorldCreator sessionCreate = new WorldCreator(worldName);
        sessionCreate.environment(World.Environment.NORMAL);
        sessionCreate.type(WorldType.FLAT);
        sessionCreate.generatorSettings("minecraft:bedrock,2*minecraft:dirt,minecraft:grass_block;minecraft:plains");
        sessionCreate.generateStructures(false);
        sessionCreate.seed(4543815200869249576L);

        // TODO Add logic session
    }
}

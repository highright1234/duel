package com.github.highright1234.duel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.projecttl.plugin.duel.DuelPlugin;
import org.projecttl.plugin.duel.utils.CreateSessionWorld;
import org.projecttl.plugin.duel.utils.SyncTimerWorldBoarder;

public class Before {

    private DuelPlugin plugin;
    public Before(DuelPlugin plugin) {
        this.plugin = plugin;
    }

    public static Player redPlayer;
    public static Player bluePlayer;

    CreateSessionWorld createSession = new CreateSessionWorld(plugin, redPlayer);

    private final Location red_location = new Location(Bukkit.getWorld(createSession.getWorldName()), 0, 0, 0); // This is test
    private final Location blue_location = new Location(Bukkit.getWorld(createSession.getWorldName()), 0, 0, 0); // This is test
    public static boolean playing = false;

    public void before_setting(Player red, Player blue) {
        SyncTimerWorldBoarder syncTimer = new SyncTimerWorldBoarder(plugin);

        redPlayer = red;
        bluePlayer = blue;

        red.teleport(red_location);
        blue.teleport(blue_location);
        playing = true;

        syncTimer.setDefault();
    }
    static boolean check_playing() {
        return !playing;
    }
}

package com.github.highright1234.duel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Before {
    private static final Location red_location = new Location(Bukkit.getWorld("duel"), 0, 0, 0);
    private static final Location blue_location = new Location(Bukkit.getWorld("duel"), 0, 0, 0);
    public static Player redPlayer;
    public static Player bluePlayer;
    public static boolean playing = false;

    static void before_setting(Player red, Player blue) {
        redPlayer = red;
        bluePlayer = blue;

        red.teleport(red_location);
        blue.teleport(blue_location);
        playing = true;
    }
    static boolean check_playing() {
        return !playing;
    }
}

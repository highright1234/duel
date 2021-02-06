package com.github.highright1234.duel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class before {
    private static final Location red_location = new Location(Bukkit.getWorld("duel"), 0, 0, 0);
    private static final Location blue_location = new Location(Bukkit.getWorld("duel"), 0, 0, 0);
    private static boolean playing = false;

    static void before_setting(Player red, Player blue) {
        red.teleport(red_location);
        blue.teleport(blue_location);
        playing = true;
    }
    static void playing_end() {
        playing = false;
    }

    static boolean check_playing() {
        return !playing;
    }
}

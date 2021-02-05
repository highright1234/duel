package com.github.highright1234.duel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArgumentForCommands implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("duel")) {
                if (args.length == 1) {
                    ArrayList<String> firstArgument = new ArrayList<>();
                    firstArgument.add("accept");
                    firstArgument.add("deny");
                    firstArgument.add("send");

                    return firstArgument;
                }
            }
        }
        return null;
    }
}

package org.projecttl.plugin.duel.commands.arguments

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class ArgumentForItemAdder: TabCompleter {

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): List<String>? {
        if (sender is Player) {

            if (command.name.equals("duelitem", true)) {
                when (args.size) {
                    1 -> {
                        val firstArgument: ArrayList<String> = ArrayList()
                        firstArgument.add("gui")

                        return firstArgument
                    }
                }
            }
        }
        return null
    }
}
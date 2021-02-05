package org.projecttl.plugin.duel.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.projecttl.plugin.duel.listeners.DuelGUIListener

class GUIItemAdder: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val duelGui = DuelGUIListener()

        if (sender is Player) {
            if (command.name == "duelitem") {
                when {
                    args.isNullOrEmpty() -> {
                        return false
                    }

                    // Debug Code
                    args.size == 1 -> {
                        if (args[0].equals("gui", true)) {
                            val itemStack = ItemStack(Material.CLOCK).let {
                                val meta = it.itemMeta
                                meta.displayName.equals(duelGui.displayName,true)

                                it.itemMeta = meta
                                it
                            }

                            sender.inventory.addItem(itemStack)
                            return true
                        }
                    }
                }
            }
        }
        return false
    }
}
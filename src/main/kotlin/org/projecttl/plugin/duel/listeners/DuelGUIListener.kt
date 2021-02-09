package org.projecttl.plugin.duel.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.projecttl.api.inventorygui.utils.AddGuiItem
import org.projecttl.plugin.duel.utils.GetVoidItem

class DuelGUIListener: Listener {

    val displayName = "${ChatColor.YELLOW}Duel"
    private val voidName = "${ChatColor.DARK_GRAY}VOID"
    private val killStatus = "${ChatColor.GREEN}Kill Status"
    private val deathStatus = "${ChatColor.RED}Death Status"

    @EventHandler
    fun onGuiOpen(event: PlayerInteractEvent) {
        val guiItem = AddGuiItem()

        val player = event.player
        val action = event.action

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (player.inventory.itemInMainHand.type == Material.CLOCK) {
                if (player.inventory.itemInMainHand.itemMeta.displayName === displayName) {
                    val inventory = Bukkit.createInventory(null, 45, displayName).let {
                        guiItem.onCreateItem(
                            it,
                            20,
                            Material.GRASS,
                            "${ChatColor.DARK_GREEN}Grassland",
                            listOf("${ChatColor.GOLD}You can play Grassland map."),
                            1,
                            false
                        )

                        guiItem.onCreateItem(
                            it,
                            16,
                            Material.IRON_SWORD,
                            killStatus,
                            listOf(null),
                            1,
                            false
                        )

                        guiItem.onCreateItem(
                            it,
                            16,
                            Material.RED_BANNER,
                            deathStatus,
                            listOf(null),
                            1,
                            false
                        )

                        guiItem.onCreateExitButton(it, 44)

                        GetVoidItem(it, 0, voidName)
                        GetVoidItem(it, 1, voidName)
                        GetVoidItem(it, 2, voidName)
                        GetVoidItem(it, 3, voidName)
                        GetVoidItem(it, 4, voidName)
                        GetVoidItem(it, 5, voidName)
                        GetVoidItem(it, 6, voidName)
                        GetVoidItem(it, 7, voidName)
                        GetVoidItem(it, 8, voidName)

                        GetVoidItem(it, 9, voidName)
                        GetVoidItem(it, 17, voidName)

                        GetVoidItem(it, 18, voidName)
                        GetVoidItem(it, 26, voidName)

                        GetVoidItem(it, 27, voidName)
                        GetVoidItem(it, 35, voidName)

                        GetVoidItem(it, 36, voidName)
                        GetVoidItem(it, 37, voidName)
                        GetVoidItem(it, 38, voidName)
                        GetVoidItem(it, 39, voidName)
                        GetVoidItem(it, 40, voidName)
                        GetVoidItem(it, 41, voidName)
                        GetVoidItem(it, 42, voidName)
                        GetVoidItem(it, 43, voidName)

                        it
                    }

                    player.openInventory(inventory)
                }
            }
        }
    }
}
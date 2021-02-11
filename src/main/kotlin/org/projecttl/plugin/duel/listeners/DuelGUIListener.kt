package org.projecttl.plugin.duel.listeners

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.projecttl.api.inventorygui.utils.CreateGUI

class DuelGUIListener: Listener {

    val displayName = "${ChatColor.YELLOW}Duel"
    private val voidName = "${ChatColor.DARK_GRAY}VOID"
    private val killStatus = "${ChatColor.GREEN}Kill Status"
    private val deathStatus = "${ChatColor.RED}Death Status"

    @EventHandler
    fun onGuiOpen(event: PlayerInteractEvent) {
        val player = event.player
        val action = event.action

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (player.inventory.itemInMainHand.type == Material.CLOCK) {
                if (player.inventory.itemInMainHand.itemMeta.displayName === displayName) {
                    val createGUI: CreateGUI = CreateGUI(45, displayName).let {
                        it.setItem(
                            ItemStack(Material.GRASS),
                            "${ChatColor.DARK_GREEN}Grassland",
                            listOf("${ChatColor.GOLD}You can play Grassland map."),
                            20
                        )

                        it.setItem(
                            ItemStack(Material.IRON_SWORD),
                            killStatus,
                            16
                        )

                        it.setItem(ItemStack(Material.RED_BANNER),
                            deathStatus,
                            17
                        )

                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 0,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 1,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 2,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 3,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 4,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 5,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 6,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 7,)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 8,)

                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 9)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 17)

                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 18)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 26)

                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 27)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 35)

                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 36)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 37)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 38)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 39)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 40)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 41)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 42)
                        it.setItem(ItemStack(Material.BLACK_STAINED_GLASS_PANE), voidName, 43)

                        it
                    }

                    createGUI.openInventory(player)
                }
            }
        }
    }
}
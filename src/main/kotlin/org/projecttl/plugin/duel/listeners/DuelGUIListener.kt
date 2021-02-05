package org.projecttl.plugin.duel.listeners

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.projecttl.api.inventorygui.utils.AddGuiItem
import org.projecttl.plugin.duel.utils.SettingVoid

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
                if (player.inventory.itemInMainHand.itemMeta.displayName.equals(displayName, true)) {
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

                        SettingVoid(it, 0, voidName)
                        SettingVoid(it, 1, voidName)
                        SettingVoid(it, 2, voidName)
                        SettingVoid(it, 3, voidName)
                        SettingVoid(it, 4, voidName)
                        SettingVoid(it, 5, voidName)
                        SettingVoid(it, 6, voidName)
                        SettingVoid(it, 7, voidName)
                        SettingVoid(it, 8, voidName)

                        SettingVoid(it, 9, voidName)
                        SettingVoid(it, 17, voidName)

                        SettingVoid(it, 18, voidName)
                        SettingVoid(it, 26, voidName)

                        SettingVoid(it, 27, voidName)
                        SettingVoid(it, 35, voidName)

                        SettingVoid(it, 36, voidName)
                        SettingVoid(it, 37, voidName)
                        SettingVoid(it, 38, voidName)
                        SettingVoid(it, 39, voidName)
                        SettingVoid(it, 40, voidName)
                        SettingVoid(it, 41, voidName)
                        SettingVoid(it, 42, voidName)
                        SettingVoid(it, 43, voidName)

                        it
                    }

                    player.openInventory(inventory)
                }
            }
        }
    }
}
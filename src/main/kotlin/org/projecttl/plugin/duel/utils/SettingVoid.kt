package org.projecttl.plugin.duel.utils

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.projecttl.api.inventorygui.utils.AddGuiItem

class SettingVoid(inventory: Inventory, inventoryLocation: Int, voidName: String): AddGuiItem() {

    // This is void from gui
    init {
        onCreateItem(inventory, inventoryLocation, Material.BLACK_STAINED_GLASS_PANE, voidName, null, 1, false)
    }
}
package org.bteitaly.warps.gui

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.item.ItemBuilder
import xyz.xenondevs.invui.item.ItemWrapper
import xyz.xenondevs.invui.window.Window

class MainMenu {

    fun open(player: Player) {

        val ite = ItemStack(Material.DIAMOND)
        ite.editMeta{ it.itemModel = NamespacedKey.fromString("warp:test") }
        val test = ItemWrapper(ite)


        val gui = Gui.builder()
            .setStructure(
                "#########",
                "#xxxtxxx#",
                "#xxxxxxx#",
                "#########"
            )
            .addIngredient('#', Item.simple(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
            .addIngredient('t', test)
            .build()

        Window.builder()
            .setTitle("Test Menu")
            .setUpperGui(gui)
            .open(player)
    }

}
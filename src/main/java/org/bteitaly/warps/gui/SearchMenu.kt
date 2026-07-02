package org.bteitaly.warps.gui

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import xyz.xenondevs.commons.provider.map
import xyz.xenondevs.commons.provider.mutableProvider
import xyz.xenondevs.invui.ExperimentalReactiveApi
import xyz.xenondevs.invui.gui.Gui
import xyz.xenondevs.invui.gui.Markers
import xyz.xenondevs.invui.gui.PagedGui
import xyz.xenondevs.invui.gui.setContent
import xyz.xenondevs.invui.item.Item
import xyz.xenondevs.invui.item.ItemBuilder
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.ItemWrapper
import xyz.xenondevs.invui.window.AnvilWindow
import xyz.xenondevs.invui.window.addRenameHandler

@OptIn(ExperimentalReactiveApi::class)
class SearchMenu {
    fun open(player: Player)  {

        val ite = ItemStack(Material.DIAMOND)
        ite.editMeta{ it.itemModel = NamespacedKey.fromString("warp:test") }
        val test = ItemWrapper(ite)


        val gui = Gui.builder()
            .setStructure(
                "#########",
                "#xxxtxxx#",
                "#########"
            )
            .addIngredient('#', Item.simple(ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)))
            .addIngredient('t', test)
            .build()

        val search = mutableProvider("")

        AnvilWindow.builder()
            .addRenameHandler(search)
            .setTitle("Test Search")
            .setLowerGui(PagedGui.itemsBuilder()
                .setStructure(
                    "#########",
                    "#########",
                    "#########",
                    "ooooooooo"
                ).addIngredient('#', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .setContent(search.map { search ->
                    Material.entries
                        .filter { !it.isLegacy && it.isItem }
                        .filter { it.name.contains(search, true) }
                        .map { Item.simple(ItemBuilder(it)) }
                })
            )
            .open(player)

    }
}
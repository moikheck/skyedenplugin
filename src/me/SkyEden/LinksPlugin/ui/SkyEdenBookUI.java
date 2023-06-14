package me.SkyEden.LinksPlugin.ui;

import me.SkyEden.LinksPlugin.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SkyEdenBookUI {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 1;
    public static int boxes = inv_rows * 9;

    public static void initialize() {
        inventory_name = GUIUtils.chat("&6Sky Eden Book");

        inv = Bukkit.createInventory(null, boxes);
    }

    public static Inventory GUI ( Player p ) {
        Inventory toReturn = Bukkit.createInventory(null, boxes, inventory_name);

        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 0, "&bWarps", "&fView list of available warps");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(GUIUtils.chat("&bWarps"))) {
            p.openInventory(WarpsUI.GUI(p));
        }
    }

}

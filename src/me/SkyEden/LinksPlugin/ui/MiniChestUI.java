package me.SkyEden.LinksPlugin.ui;

import me.SkyEden.LinksPlugin.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MiniChestUI {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 1;
    public static int boxes = inv_rows * 9;

    public static void initialize() {
        inventory_name = GUIUtils.chat("&eMinichest");

        inv = Bukkit.createInventory(null, boxes);
    }

    public static Inventory GUI ( Player p ) {
        Inventory toReturn = Bukkit.createInventory(null, boxes, inventory_name);

        //GUIUtils.createItem(inv, "OAK_PLANKS", 2, 0, "&dWood Plank Test", "Lore line 1", "loreLineT2o");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(GUIUtils.chat("&eMinichest"))) {
            System.out.println("CLICKED");
        }
    }

}

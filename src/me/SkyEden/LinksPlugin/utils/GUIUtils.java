package me.SkyEden.LinksPlugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIUtils {

    public static String chat ( String s ) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static ItemStack createItem(Inventory inv, String materialID, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        item = new ItemStack(Material.getMaterial(materialID), amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(GUIUtils.chat(displayName));

        for (String s : loreString) {
            lore.add(GUIUtils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot, item);


        return item;
    }

    public static ItemStack createItemByte(Inventory inv, String materialID, int byteID, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        item = new ItemStack(Material.getMaterial(materialID), amount, (short) byteID);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(GUIUtils.chat(displayName));

        for (String s : loreString) {
            lore.add(GUIUtils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot, item);


        return item;
    }
}

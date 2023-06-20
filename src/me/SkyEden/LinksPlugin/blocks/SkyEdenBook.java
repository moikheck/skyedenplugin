package me.SkyEden.LinksPlugin.blocks;

import me.SkyEden.LinksPlugin.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SkyEdenBook {

    public static ItemStack book;
    public static ItemMeta bookMeta;

    public static void initialize() {
        book = new ItemStack(Material.ENCHANTED_BOOK);
        bookMeta = book.getItemMeta();
        bookMeta.setDisplayName(GUIUtils.chat("&6● &4&lSky Eden &r&6Book &6●"));
        List<String> lore = new ArrayList<>();
        lore.add(GUIUtils.chat("&7Right Click to open the menu!"));
        bookMeta.setLore(lore);
        book.setItemMeta(bookMeta);

    }
}

package me.SkyEden.LinksPlugin.ui;

import me.SkyEden.LinksPlugin.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WarpsUI {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 4;
    public static int boxes = inv_rows * 9;

    public static void initialize() {
        inventory_name = GUIUtils.chat("&bWarps");

        inv = Bukkit.createInventory(null, boxes);
    }

    public static Inventory GUI ( Player p ) {
        Inventory toReturn = Bukkit.createInventory(null, boxes, inventory_name);

        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 0, "&bLighthouse", "&fWarp to the WaterHub Lighthouse");
        GUIUtils.createItem(inv, "WATER_BUCKET", 1, 1, "&bWaterHub", "&fWarp to WaterHub");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 2, "&bVolcano", "&fWarp to the FireHub Volcano");
        GUIUtils.createItem(inv, "FIRE_CHARGE", 1, 3, "&bFireHub", "&fWarp to FireHub");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 4, "&bGreat Oak", "&fWarp to the EarthHub Great Oak");
        GUIUtils.createItem(inv, "OAK_SAPLING", 1, 5, "&bEarthHub", "&fWarp to EarthHub");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 6, "&bRed Guild", "&fWarp to the WindHub Red Guild");
        GUIUtils.createItem(inv, "WHITE_WOOL", 1, 7, "&bWindHub", "&fWarp to WindHub");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 8, "&bSkyMinia", "&fWarp to SkyMinia");
        GUIUtils.createItem(inv, "GOLDEN_APPLE", 1, 9, "&bSkyMoria", "&fWarp to SkyMoria");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 10, "&bSnow Fort", "&fWarp to the FrostHub Snow Fort");
        GUIUtils.createItem(inv, "SNOWBALL", 1, 11, "&bFrostHub", "&fWarp to FrostHub");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 12, "&bAncient Hand", "&fWarp to StarHub's Ancient Hand");
        GUIUtils.createItem(inv, "HEART_OF_THE_SEA", 1, 13, "&b???", "&fWarp to the Overworld Anomaly");
        GUIUtils.createItem(inv, "ENCHANTED_GOLDEN_APPLE", 1, 14, "&bThe Rift", "&fWarp to The Rift");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        String c = clicked.getItemMeta().getDisplayName();
        if (c.equalsIgnoreCase(GUIUtils.chat("&bLighthouse"))) {
            p.performCommand("warp waterorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bWaterHub"))) {
            p.performCommand("warp waterhub");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bVolcano"))) {
            p.performCommand("warp fireorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bFireHub"))) {
            p.performCommand("warp firehub");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bGreat Oak"))) {
            p.performCommand("warp earthorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bEarthHub"))) {
            p.performCommand("warp earthhub");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bRed Guild"))) {
            p.performCommand("warp windorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bWindHub"))) {
            p.performCommand("warp windhub");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bSkyMinia"))) {
            p.performCommand("warp skymoriaorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bSkyMoria"))) {
            p.performCommand("warp skymoria");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bSnow Fort"))) {
            p.performCommand("warp frostorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bFrostHub"))) {
            p.performCommand("warp frosthub");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bAncient Hand"))) {
            p.performCommand("warp starorb");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&b???"))) {
            p.performCommand("warp riftportal");
        } else if (c.equalsIgnoreCase(GUIUtils.chat("&bThe Rift"))) {
            p.performCommand("warp therift");
        }
    }

}

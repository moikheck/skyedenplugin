package me.SkyEden.LinksPlugin.listeners;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.ui.MiniChestUI;
import me.SkyEden.LinksPlugin.ui.SkyEdenBookUI;
import me.SkyEden.LinksPlugin.ui.WarpsUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private Main plugin;
    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick (InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (title.equals(MiniChestUI.inventory_name)) {
//            e.setCancelled(true);
            if (title.equals(MiniChestUI.inventory_name)) {
                MiniChestUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        } else if (title.equals(WarpsUI.inventory_name)) {
            e.setCancelled(true);
            WarpsUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        } else if (title.equals(SkyEdenBookUI.inventory_name)) {
            e.setCancelled(true);
            SkyEdenBookUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
    }
}

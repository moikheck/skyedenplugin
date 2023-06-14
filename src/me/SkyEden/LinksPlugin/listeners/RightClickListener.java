package me.SkyEden.LinksPlugin.listeners;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.blocks.MiniChest;
import me.SkyEden.LinksPlugin.blocks.SkyEdenBook;
import me.SkyEden.LinksPlugin.ui.SkyEdenBookUI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class RightClickListener implements Listener {
    private Main plugin;
    public RightClickListener (Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockClick(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null)
            return;

        if ( event.getAction().equals(Action.RIGHT_CLICK_BLOCK) ) {
            BlockState block = event.getClickedBlock().getState();
            if (block instanceof Skull) {
                Skull skull = (Skull) block;
                event.setCancelled(true);
                try {
                    UUID uuid = skull.getOwnerProfile().getUniqueId();
                    if (uuid.toString().equals(MiniChest.hashAsID.toString())) {
                        Player player = event.getPlayer();
                        Location loc = event.getClickedBlock().getLocation();
                        player.playSound(loc, Sound.BLOCK_CHEST_OPEN, 5, 10);
                    }
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
            }
        }
    }

//    @EventHandler
//    public void onBlockPlace(BlockPlaceEvent event) {
//        if (event == null)
//            return;
//        BlockState block = event.getBlockPlaced().getState();
//        if (block instanceof Skull) {
//            Skull skull = (Skull) block;
//            try {
//                UUID uuid = skull.getOwnerProfile().getUniqueId();
//                if (uuid.toString().equals(MiniChest.hashAsID.toString())) {
////                    System.out.println("Minichest placed!");
////                    TileState state = (TileState) event.getBlockPlaced().getState();
////                    PersistentDataContainer chest = state.getPersistentDataContainer();
////                    NamespacedKey namespacedKey = new NamespacedKey(plugin, "minichest");
////                    chest.set(namespacedKey, PersistentDataType.STRING, event.getBlockPlaced().getLocation().toString());
////
////                    state.update();
////                    event.getPlayer().sendMessage("Minichest created!");
//                }
//            } catch (NullPointerException e) {
//                System.out.println(e);
//            }
//        }
//    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        if (p.getInventory().getItemInMainHand().equals(SkyEdenBook.book)) {
            event.setCancelled(true);
            p.openInventory(SkyEdenBookUI.GUI(p));
        }
    }
}

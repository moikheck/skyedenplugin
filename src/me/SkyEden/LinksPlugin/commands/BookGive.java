package me.SkyEden.LinksPlugin.commands;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.blocks.SkyEdenBook;
import me.SkyEden.LinksPlugin.ui.MiniChestUI;
import me.SkyEden.LinksPlugin.ui.SkyEdenBookUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BookGive implements CommandExecutor {
    public Main plugin;

    public BookGive(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        p.getInventory().addItem(SkyEdenBook.book);

        return true;
    }
}

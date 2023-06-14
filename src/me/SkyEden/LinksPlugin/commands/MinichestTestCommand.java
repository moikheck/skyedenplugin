package me.SkyEden.LinksPlugin.commands;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.ui.MiniChestUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinichestTestCommand implements CommandExecutor {
    public Main plugin;

    public MinichestTestCommand(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (p.hasPermission("minichest.use")) {
            p.openInventory(MiniChestUI.GUI(p));
        }

        return true;
    }
}

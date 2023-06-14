package me.SkyEden.LinksPlugin.commands;

import me.SkyEden.LinksPlugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Links implements CommandExecutor {
    public Main plugin;
    public Links(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("links")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1             \u2756 &9Sky Eden Links &1\u2756"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&9=================================="));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1\u2756 &3Server Website:   &b   " + plugin.getConfig().getString("server-website") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1\u2756 &3Donations:   &b          " + plugin.getConfig().getString("donations") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1\u2756 &3Dynmap:   &b             " + plugin.getConfig().getString("dynmap") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1\u2756 &3Forester Apps:   &b    " + plugin.getConfig().getString("forester") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&1\u2756 &3Runes List:   &b         " + plugin.getConfig().getString("runes") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3Discord:   &b                " + plugin.getConfig().getString("discord") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3Helper Apps:   &b           " + plugin.getConfig().getString("applications") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3Information Tab:   &b      " + plugin.getConfig().getString("information") ));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3PMC Page:   &b               " + plugin.getConfig().getString("pmc-website") ));
            return true;
        }
        return false;
    }
}

package me.SkyEden.LinksPlugin.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("forum") || cmd.getName().equalsIgnoreCase("forums")){
            if(sender instanceof Player){

                List<String> list = new ArrayList<>();
                list.add("applications");
                list.add("aqua");
                list.add("aqualore");
                list.add("aqua-lore");
                list.add("forester");
                list.add("forum");
                list.add("forums");
                list.add("general");
                list.add("help");
                list.add("information");
                list.add("news");
                list.add("requests");
                list.add("?");

                return list;

            }
        }
        return null;
    }
}

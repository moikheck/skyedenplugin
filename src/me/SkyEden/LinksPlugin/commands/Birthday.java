package me.SkyEden.LinksPlugin.commands;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.ui.DateValidatorUsingDateFormat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class Birthday implements CommandExecutor {
    public Main plugin;

    public Birthday(Main main) {
        this.plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File birthdaysFile = new File("plugins/SkyEden/Birthdays.yml");
        String birthday;
        String month;
        DateValidatorUsingDateFormat validator;
        boolean part3Bool;
        if (label.equalsIgnoreCase("setbirthday")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage:   &b/setbirthday [mm/dd]"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAllows you to input your birthday."));
                return true;
            } else {
                birthday = args[0];
                validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");
                month = birthday.concat("/2004");
                part3Bool = validator.isValid(month);
                if (birthday.contains("/") && part3Bool) {
                    YamlConfiguration yaml = YamlConfiguration.loadConfiguration(birthdaysFile);
                    String lastCelebrated = yaml.get(sender.getName().concat(".lastCelebrated")).toString();
                    yaml.createSection(sender.getName());
                    yaml.createSection(sender.getName().concat(".birthday"));
                    yaml.createSection(sender.getName().concat(".lastCelebrated"));
                    yaml.set(sender.getName().concat(".birthday"), birthday);
                    yaml.set(sender.getName().concat(".lastCelebrated"), lastCelebrated);

                    try {
                        yaml.save("plugins/SkyEden/Birthdays.yml");
                    } catch (IOException var14) {
                        var14.printStackTrace();
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Birthday set successfully!"));
                    return true;
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage:   &b/setbirthday [mm/dd]"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAllows you to input your birthday."));
                    return true;
                }
            }
        } else if (label.equalsIgnoreCase("getbirthday")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage:   &b/getbirthday [user]"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bAllows you to see the birthday of another player."));
                return true;
            } else {
                birthday = this.getBirthday(args[0]);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', args[0].concat("'s birthday is: ").concat(birthday)));
                return true;
            }
        } else {
            String today;
            if (label.equalsIgnoreCase("birthdays")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage:   &b/birthdays [mm/dd]"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bLists all players with that birthday."));
                    return true;
                } else {
                    birthday = args[0];
                    validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");
                    month = birthday.concat("/2004");
                    part3Bool = validator.isValid(month);
                    if (birthday.contains("/") && part3Bool) {
                        today = this.birthdays(birthday);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Players with a birthday on ".concat(birthday).concat(": ").concat(today)));
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage:   &b/birthdays [mm/dd]"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bLists all players with that birthday."));
                        return true;
                    }
                }
            } else if (label.equalsIgnoreCase("birthdaypresent")) {
                birthday = this.getBirthday(sender.getName());
                String[] split = LocalDate.now().toString().split("-");
                month = split[1];
                String day = split[2];
                today = month.concat("/").concat(day);
                YamlConfiguration yaml = YamlConfiguration.loadConfiguration(birthdaysFile);
                String lastCelebrated = yaml.get(sender.getName().concat(".lastCelebrated")).toString();
                if (today.equalsIgnoreCase(birthday) && !lastCelebrated.equalsIgnoreCase(split[0])) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dHappy Birthday! Here's a present!"));
                    yaml.createSection(sender.getName());
                    yaml.createSection(sender.getName().concat(".birthday"));
                    yaml.createSection(sender.getName().concat(".lastCelebrated"));
                    yaml.set(sender.getName().concat(".lastCelebrated"), split[0]);
                    yaml.set(sender.getName().concat(".birthday"), today);

                    try {
                        yaml.save("plugins/SkyEden/Birthdays.yml");
                    } catch (IOException var15) {
                        var15.printStackTrace();
                    }

                    return true;
                } else {
                    if (today.equalsIgnoreCase(birthday) && lastCelebrated.equalsIgnoreCase(split[0])) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "You've already celebrated your birthday this year."));
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Today is not your birthday. Try again on your birthday."));
                    }

                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public String getBirthday(String user) {
        File birthdaysFile = new File("plugins/SkyEden/Birthdays.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(birthdaysFile);

        String yamlString;
        try {
            yamlString = yaml.get(user.concat(".birthday")).toString();
        } catch (NullPointerException var6) {
            yamlString = "unset";
        }

        return yamlString;
    }

    public String birthdays(String date) {
        File birthdaysFile = new File("plugins/SkyEden/Birthdays.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(birthdaysFile);
        Set<String> yamlKeys = yaml.getKeys(false);
        List<String> list = new ArrayList();
        System.out.println(yamlKeys);
        Iterator var6 = yamlKeys.iterator();

        while(var6.hasNext()) {
            String player = (String)var6.next();
            System.out.println(player);
            if (date.equals(this.getBirthday(player))) {
                list.add(player);
            }
        }

        return list.toString().replace("\n", ", ").replace("[", "").replace("]", "");
    }
}

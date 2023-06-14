package me.SkyEden.LinksPlugin;

import me.SkyEden.LinksPlugin.blocks.MiniChest;
import me.SkyEden.LinksPlugin.blocks.SkyEdenBook;
import me.SkyEden.LinksPlugin.commands.Birthday;
import me.SkyEden.LinksPlugin.commands.BookGive;
import me.SkyEden.LinksPlugin.commands.Links;
import me.SkyEden.LinksPlugin.listeners.InventoryClickListener;
import me.SkyEden.LinksPlugin.listeners.RightClickListener;
import me.SkyEden.LinksPlugin.recipes.crafting.MiniChestRecipe;
import me.SkyEden.LinksPlugin.ui.MiniChestUI;
import me.SkyEden.LinksPlugin.ui.SkyEdenBookUI;
import me.SkyEden.LinksPlugin.ui.WarpsUI;
import me.SkyEden.LinksPlugin.utils.TabCompletion;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        new InventoryClickListener(this);
        new RightClickListener(this);
        MiniChestUI.initialize();
        MiniChest.initialize();
        SkyEdenBookUI.initialize();
        WarpsUI.initialize();
        SkyEdenBook.initialize();
        new MiniChestRecipe(this);
        registerCmds();
        this.getCommand("forum").setTabCompleter(new TabCompletion());
        System.out.println("[SkyEden] Sky Eden Plugin enabled.");
    }

    @Override
    public void onDisable() {

    }

    public void registerCmds() {
        this.getCommand("links").setExecutor(new Links(this));
        this.getCommand("setBirthday").setExecutor(new Birthday(this));
        this.getCommand("getBirthday").setExecutor(new Birthday(this));
        this.getCommand("birthdays").setExecutor(new Birthday(this));
        this.getCommand("birthdayPresent").setExecutor(new Birthday(this));
//        this.getCommand("minichestTest").setExecutor(new MinichestTestCommand(this));
        this.getCommand("skyedenbook").setExecutor(new BookGive(this));
    }

}
